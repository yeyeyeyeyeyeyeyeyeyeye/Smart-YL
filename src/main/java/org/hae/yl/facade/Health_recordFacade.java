package org.hae.yl.facade;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hae.yl.entity.Health_record;
import org.hae.yl.entity.Login_log;
import org.hae.yl.service.Health_recordService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 健康档案与数据管理 Facade 层
 * 负责聚合底层 Service 的业务逻辑
 */
@Component
public class Health_recordFacade {

    @Resource
    private Health_recordService health_recordService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Health_record> queryByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);  // 启动分页
        List<Health_record> list = health_recordService.SelectAll();  // 原始查询
        return new PageInfo<>(list);  // 包装分页对象返回
    }

    /**
     * 用户每日健康打卡记录
     */
    public void Insert(Health_record health_record){
        health_recordService.Insert(health_record);
    }

    /**
     * 查询用户完整健康档案
     */
    public Health_record SelectById(int id){
        return health_recordService.SelectById(id);
    }

    /**
     * 获取用户最近一次健康打卡状态
     * @param id
     * @return
     */
    public Health_record SelectByIdEndSelection(int id){
        return health_recordService.SelectByIdEndSelection(id);
    }

    /**
     * 获取某指标的折线图数据（体温、血压等）
     * @param id
     * @return
     */
    public List<Health_record> SelectAllSignsData(int id){
        return health_recordService.SelectAllSignsData(id);
    }


    /**
     * 健康异常预警检测（如高血压、发热等
     * @param id
     * @return 风险等级（0=正常，1=轻度异常，2=中度异常，3=严重异常，4=危急异常）
     */
    public int HealthAbnormalityWarning(int id){
        Health_record health_record = SelectByIdEndSelection(id);
        String blood_pressure = health_record.getBlood_pressure();  //血压
        int heart_rate = health_record.getHeart_rate();             //心率
        BigDecimal temperature = health_record.getTemperature();    //体温

        int riskLevel = 0; // 初始级别

        // ========== 体温判断 ==========
        double temp = temperature.doubleValue();
        if (temp < 35.5) riskLevel = Math.max(riskLevel, 2);        // 体温过低
        else if (temp > 41.0) riskLevel = 4;                        // 超高热
        else if (temp > 39.0) riskLevel = Math.max(riskLevel, 3);   // 高度发热
        else if (temp > 38.0) riskLevel = Math.max(riskLevel, 2);   // 中度发热
        else if (temp > 37.2) riskLevel = Math.max(riskLevel, 1);   // 轻度发热

        // ========== 血压判断 ==========
        try {
            String[] bp = blood_pressure.split("/");
            int sbp = Integer.parseInt(bp[0]); // 收缩压（高压）
            int dbp = Integer.parseInt(bp[1]); // 舒张压（低压）

            if (sbp >= 180 || dbp >= 110) riskLevel = Math.max(riskLevel, 3); // 高血压Ⅲ级
            else if (sbp >= 160 || dbp >= 100) riskLevel = Math.max(riskLevel, 2); // 高血压Ⅱ级
            else if (sbp >= 140 || dbp >= 90) riskLevel = Math.max(riskLevel, 1);  // 高血压Ⅰ级
            else if (sbp < 90 || dbp < 60) riskLevel = Math.max(riskLevel, 2);     // 低血压
        } catch (Exception e) {
            // 血压格式异常，略过处理（或可加入日志）
        }

        // ========== 心率判断 ==========
        if (heart_rate < 60) riskLevel = Math.max(riskLevel, 1);         // 心动过缓
        else if (heart_rate > 140) riskLevel = 3;                        // 重度过快
        else if (heart_rate > 120) riskLevel = Math.max(riskLevel, 2);   // 中度过快
        else if (heart_rate > 100) riskLevel = Math.max(riskLevel, 1);   // 轻度过快

        return riskLevel;
    }

    //健康异常处理  判定等级自动发送处理工单
    public void HealthAbnormalityWarning_work(int id){
        int level = HealthAbnormalityWarning(id);
        //风险等级（0=正常，1=轻度异常，2=中度异常，3=严重异常，4=危急异常）

        switch (level){
            case 1:
                //轻度异常
                // 可以观察
                break;
            case 2:
                //中度异常
                // 开工单体检
                break;
            case 3:
                //严重异常
                // 开工单体检，就医
                break;
            case 4:
                //危急异常
                // 紧急就医/通知家属
                break;
            default:
                //正常
                break;
        }
    }


//    生成健康风险分析报告（DeepSeek 待定）


    /**
     * 查询所有
     */
    public List<Health_record> SelectAll(){
        return health_recordService.SelectAll();
    }

    /**
     * 根据 Id 修改
     */
    public void Update(int id, Health_record health_record){
        health_recordService.Update(id, health_record);
    }

    /**
     * 根据 Id 删除
     * 根据 Id 批量删除
     */
    public void DeleteById(int id){
        health_recordService.DeleteById(id);
    }

    public void DeleteByIdbatch(List<Integer> ids){
        health_recordService.DeleteByIdbatch(ids);
    }
}
