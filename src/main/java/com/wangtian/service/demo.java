package com.wangtian.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class demo {
//    Map<Object, Map<Object, Map<Object, List<QueryProOilMassFlowMeasurVouFormHairOilDataOutput>>>> mapMap = outputXPageResult.getResult().stream().collect(
//            Collectors.groupingBy(QueryProOilMassFlowMeasurVouFormHairOilDataOutput::getDataSorting,
//                    Collectors.groupingBy(QueryProOilMassFlowMeasurVouFormHairOilDataOutput::getDataSortingTow,
//                            Collectors.groupingBy(QueryProOilMassFlowMeasurVouFormHairOilDataOutput::getDataSortingThree))
//                    EASTERN_STORAGE_TRANSPORTATION_REFINED_OIL
//            ));
//
//

    public static void main(String[] args) {
        Date date = new Date();
//        System.out.println(getEndOfDay(date));

        BigDecimal decimal1 = new BigDecimal(0);
        decimal1.setScale(4, RoundingMode.HALF_UP);
        System.out.println(decimal1);
    }
//    @XText("新增发油数据--未使用")
//    @XApiPost
//    public XServiceResult createProOilMassFlowMeasurVouFormHairOil(XContext context, CreateProOilMassFlowMeasurVouFormHairOilInput input) {
//        ProOilMassFlowMeasurVouFormHairOilMapper mapper = context.getBean(ProOilMassFlowMeasurVouFormHairOilMapper.class);
//        ProOilMassFlowMeasurVouFormHairOilEnt entity = new ProOilMassFlowMeasurVouFormHairOilEnt();
//        BpsWorkFlowProcessService bpmService = context.getBean(BpsWorkFlowProcessService.class);
//        PpsUserSession session = context.getSession(PpsUserSession.class);
//        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
//        XCopyUtils.copyObject(input, entity);
//        entity.setId(uuid);
//        if (input.getStorageStatus() != EasternStorageTransortationConstants.SAVED) {
//            StartProcessInput startProcessInput = new StartProcessInput();
//            startProcessInput.setProcessCode(this.processCode);
//            startProcessInput.setBsnsDetailUrl(input.getBsnsDetailUrl());
//            startProcessInput.setBsnsId(entity.getId());
//            //启动相应的工作流转填报
//            bpmService.startProcess(context, startProcessInput);
//            entity.setAuditStatus(EasternStorageTransortationConstants.UNDER_REVIEW);
//            entity.setAuditorId(session.getId());
//            entity.setAuditorName(session.getUserName());
//        } else {
//            entity.setAuditStatus(EasternStorageTransortationConstants.SAVED);
//            entity.setAuditorId(session.getId());
//            entity.setAuditorName(session.getUserName());
//        }
//        //0是删除1是正常存在  用备用字段代替
//        entity.setAlternateFieldsOne("1");
//        entity.setmOuId(session.getOuId());
//        entity.setmOuName(session.getOuName());
//        entity.setCreateById(session.getId());
//        entity.setCreateByName(session.getUserName());
//        entity.setDataDate(new Date());
//        entity.setCreateTime(new Date());
//        mapper.insert(entity);
//        oilDataInsert(context, input.getOilTagNumberList(), entity.getDataDate(), uuid);
//        return XServiceResult.OK;
//    }


//    @XText("插入或编辑油品数据表未使用")
//    public static void oilDataInsert(XContext context, List<Map<String, Object>> oilTagNumberList, Date dataDate, String uuid) {
//        ProOilMassFlowMeasurVouFormHairOilDataService service = context.getBean(ProOilMassFlowMeasurVouFormHairOilDataService.class);
//        Set<String> set = new HashSet<>();
//        List<Map<String, Object>> mapArrayList = oilTagNumberList.stream()
//                .filter(map -> map.get("oilProduct") != null).filter(map -> map.get("flowMeterTagNumber") != null)
//                .collect(Collectors.groupingBy(o -> {
//                    //暂存所有key
//                    set.addAll(o.keySet());
//                    //按oilProduct和flowMeterTagNumber分组
//                    return o.get("oilProduct").toString() + "|" + o.get("flowMeterTagNumber");
//                }))
//                .entrySet().stream().map(o -> {
//                    //合并
//                    Map<String, Object> map = o.getValue().stream().flatMap(m -> {
//                        return m.entrySet().stream();
//                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));
//                    return map;
//                }).collect(Collectors.toList());
//        //计算对应的数据差
//        for (int i = 0; i < mapArrayList.size(); i++) {
//            Map<String, Object> stringObjectMap = mapArrayList.get(i);
//            if (!StringUtils.isEmpty(stringObjectMap.get("frontReading").toString()) && !StringUtils.isEmpty(stringObjectMap.get("rearReading").toString())) {
//                //前读数
//                BigDecimal frontReading = new BigDecimal(stringObjectMap.get("frontReading").toString());
//                //后读数
//                BigDecimal rearReading = new BigDecimal(stringObjectMap.get("rearReading").toString());
//                //读数差
//                BigDecimal readingDifference = rearReading.subtract(frontReading);
//                stringObjectMap.put("readingDifference", readingDifference);
//            }
//        }
//        //流量计走数(吨)
//        List<Map<String, Object>> allList = new ArrayList<>();
//        Map<String, Map<String, Object>> result = new HashMap<>();
//        for (Map<String, Object> map : mapArrayList) {
//            String newId = map.get("oilProduct").toString();
//            if (!StringUtils.isEmpty(map.get("readingDifference").toString())) {
//                BigDecimal value = new BigDecimal(map.get("readingDifference").toString());
//                if (result.containsKey(newId)) {
//                    BigDecimal temp = new BigDecimal(0);
//                    if (!StringUtils.isEmpty(result.get(newId).get("readingDifference").toString())) {
//                        temp = new BigDecimal(result.get(newId).get("readingDifference").toString());
//                    }
//                    value = temp.add(value);
//                    result.get(newId).put("flowMeterRuns", value);
//                    continue;
//                }
//                result.put(newId, map);
//                allList.add(map);
//            }
//        }
//        //将计算出的数据添加到相应的数据及
//        List<Map<String, Object>> mapList = mapArrayList.stream().map(m -> {
//            allList.stream().filter(m2 -> Objects.equals(m.get("oilProduct"), m2.get("oilProduct"))).forEach(m2 -> {
//                if (StringUtils.isNotEmpty(m2.get("flowMeterRuns").toString())){
//                    m.put("flowMeterRuns", m2.get("flowMeterRuns"));
//                    CreateProOilMassFlowMeasurVouFormHairOilDataInput input = JSON.parseObject(JSON.toJSONString(m), CreateProOilMassFlowMeasurVouFormHairOilDataInput.class);
//                    if (null==input.getOilVolume()){
//                        m.put("oilVolume", m2.get("flowMeterRuns"));
//                    }
//                }
//            });
//            return m;
//        }).collect(Collectors.toList());
//        for (int i = 0; i < mapList.size(); i++) {
//            Map<String, Object> stringObjectMap = mapList.get(i);
//            CreateProOilMassFlowMeasurVouFormHairOilDataInput input = JSON.parseObject(JSON.toJSONString(stringObjectMap), CreateProOilMassFlowMeasurVouFormHairOilDataInput.class);
//            //代表是发油是数据
//            input.setSendingPage(0);
//            input.setDataDate(dataDate);
//            input.setHairId(uuid);
//            service.createProOilMassFlowMeasurVouFormHairOilData(context, input);
//        }
//    }

//    @XText("修改发油数据")
//    @XApiPost
//    public XServiceResult updateProOilMassFlowMeasurVouFormHairOil(XContext context, UpdateProOilMassFlowMeasurVouFormHairOilInput input) {
//        ProOilMassFlowMeasurVouFormHairOilMapper mapper = context.getBean(ProOilMassFlowMeasurVouFormHairOilMapper.class);
//        BpsWorkFlowProcessService bpmService = context.getBean(BpsWorkFlowProcessService.class);
//        PpsUserSession session = context.getSession(PpsUserSession.class);
//        QueryWrapper<ProOilMassFlowMeasurVouFormHairOilEnt> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(ProOilMassFlowMeasurVouFormHairOilEnt::getId, input.getId());
//        ProOilMassFlowMeasurVouFormHairOilEnt entity = mapper.selectOne(queryWrapper);
//        if (entity == null) {
//            return XServiceResult.error(context, XError.NotFound);
//        }
//        XCopyUtils.copyObject(input, entity);
//        //是否删除用0删除1正常--字段是备用字段
//        entity.setAlternateFieldsOne("1");
//        entity.setModifyById(session.getId());
//        entity.setModifyByName(session.getUserName());
//        entity.setModifyTime(new Date());
//        if (null != entity.getAuditStatus()) {
//            if (input.getStorageStatus() != EasternStorageTransortationConstants.SAVED && entity.getStorageStatus() == EasternStorageTransortationConstants.REJECT) {
//                //启动相应的工作流转填报
//                ApprovalPassPpsInput approvalPassPpsInput = new ApprovalPassPpsInput();
//                approvalPassPpsInput.setId(input.getId());
//                approvedFormHairOilApplication(context, approvalPassPpsInput);
//                entity.setAuditStatus(EasternStorageTransortationConstants.UNDER_REVIEW);
//                entity.setAuditorId(session.getId());
//                entity.setAuditorName(session.getUserName());
//            } else if (input.getStorageStatus() != EasternStorageTransortationConstants.SAVED) {
//                StartProcessInput startProcessInput = new StartProcessInput();
//                startProcessInput.setProcessCode(this.processCode);
//                startProcessInput.setBsnsDetailUrl(input.getBsnsDetailUrl());
//                startProcessInput.setBsnsId(entity.getId());
//                //启动相应的工作流转填报
//                bpmService.startProcess(context, startProcessInput);
//                entity.setAuditStatus(EasternStorageTransortationConstants.UNDER_REVIEW);
//                entity.setAuditorId(session.getId());
//                entity.setAuditorName(session.getUserName());
//            }
//        }
//        mapper.updateById(entity);
//        oilDataInsert(context, input.getOilTagNumberList(), entity.getDataDate(), entity.getId());
//        return XServiceResult.OK;
//    }

//    @XText("获取一条表单数据")
//    @XApiPost
//    public XSingleResult<GetProOilMassFlowMeasurVouFormHairOilOutput> getProOilMassFlowMeasurVouFormHairOil(XContext context, GetProOilMassFlowMeasurVouFormHairOilInput input) {
//        ProOilMassFlowMeasurVouFormHairOilMapper mapper = context.getBean(ProOilMassFlowMeasurVouFormHairOilMapper.class);
//        ProOilMassFlowMeasurVouFormHairOilDataService service = context.getBean(ProOilMassFlowMeasurVouFormHairOilDataService.class);
//        QueryWrapper<ProOilMassFlowMeasurVouFormHairOilEnt> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(ProOilMassFlowMeasurVouFormHairOilEnt::getDataDate, input.getDataDate());
//        queryWrapper.lambda().eq(ProOilMassFlowMeasurVouFormHairOilEnt::getAlternateFieldsOne, "1");
//        ProOilMassFlowMeasurVouFormHairOilEnt entity = mapper.selectOne(queryWrapper);
//        if (entity == null) {
//            return XSingleResult.error(context, XError.NotFound);
//        }
//        QueryProOilMassFlowMeasurVouFormHairOilDataInput hairOilDataInput = new QueryProOilMassFlowMeasurVouFormHairOilDataInput();
//        hairOilDataInput.setDataDate(entity.getDataDate());
//        hairOilDataInput.setSendingPage(0);
//        XListResult<QueryProOilMassFlowMeasurVouFormHairOilDataOutput> outputXPageResult = service.queryProOilMassFlowMeasurVouFormHairOilData(context, hairOilDataInput);
//        //油品集合
//        List<Map<String, Object>> oilMaps = new ArrayList<>();
//        //点号集合
//        List<Map<String, Object>> tagMaps = new ArrayList<>();
//        //属性集合
//        List<Map<String, Object>> attributeMaps = new ArrayList<>();
//        //值集合
//        List<Map<String, Object>> dataMaps = new ArrayList<>();
//        List<String> oilCollect = outputXPageResult.getResult().stream().map(QueryProOilMassFlowMeasurVouFormHairOilDataOutput::getOilProduct).distinct().collect(Collectors.toList());
//        List<String> tagCollect = outputXPageResult.getResult().stream().map(QueryProOilMassFlowMeasurVouFormHairOilDataOutput::getFlowMeterTagNumber).distinct().collect(Collectors.toList());
//        for (int i = 0; i < oilCollect.size(); i++) {
//            IdentityHashMap<String, Object> oilCollectMap = new IdentityHashMap<>();
//            oilCollectMap.put("oilProduct", oilCollect.get(i));
//            oilMaps.add(oilCollectMap);
//        }
//        for (int i = 0; i < tagCollect.size(); i++) {
//            IdentityHashMap<String, Object> tagCollectMap = new IdentityHashMap<>();
//            tagCollectMap.put("flowMeterTagNumber", tagCollect.get(i));
//            tagMaps.add(tagCollectMap);
//        }
//        LinkedHashMap<String, Object> attribute = new LinkedHashMap<>();
//        attribute.put("前读数时间", "preReadingTime");
//        attribute.put("后读数时间", "postReadingTime");
//        attribute.put("后读数", "rearReading");
//        attribute.put("前读数", "frontReading");
//        attribute.put("读数差", "readingDifference");
//        attribute.put("流量计走数", "flowMeterRuns");
//        attribute.put("发油量", "oilVolume");
//        attributeMaps.add(attribute);
//        for (int i = 0; i < outputXPageResult.getResult().size(); i++) {
//            QueryProOilMassFlowMeasurVouFormHairOilDataOutput dataOutput = outputXPageResult.getResult().get(i);
//            LinkedHashMap<String, Object> LinkedHashMap1 = new LinkedHashMap<>();
//            LinkedHashMap<String, Object> LinkedHashMap2 = new LinkedHashMap<>();
//            LinkedHashMap<String, Object> LinkedHashMap3 = new LinkedHashMap<>();
//            LinkedHashMap<String, Object> LinkedHashMap4 = new LinkedHashMap<>();
//            LinkedHashMap<String, Object> LinkedHashMap5 = new LinkedHashMap<>();
//            LinkedHashMap<String, Object> LinkedHashMap6 = new LinkedHashMap<>();
//            LinkedHashMap<String, Object> LinkedHashMap7 = new LinkedHashMap<>();
//            if (dataOutput.getPreReadingTime() != null) {
//                LinkedHashMap1.put("oilProduct", dataOutput.getOilProduct());
//                LinkedHashMap1.put("flowMeterTagNumber", dataOutput.getFlowMeterTagNumber());
//                LinkedHashMap1.put("preReadingTime", dataOutput.getPreReadingTime());
//            }
//            if (dataOutput.getPostReadingTime() != null) {
//                LinkedHashMap2.put("oilProduct", dataOutput.getOilProduct());
//                LinkedHashMap2.put("flowMeterTagNumber", dataOutput.getFlowMeterTagNumber());
//                LinkedHashMap2.put("postReadingTime", dataOutput.getPostReadingTime());
//            }
//            if (dataOutput.getRearReading() != null) {
//                LinkedHashMap3.put("oilProduct", dataOutput.getOilProduct());
//                LinkedHashMap3.put("flowMeterTagNumber", dataOutput.getFlowMeterTagNumber());
//                LinkedHashMap3.put("rearReading", dataOutput.getRearReading());
//            }
//            if (dataOutput.getFrontReading() != null) {
//                LinkedHashMap4.put("oilProduct", dataOutput.getOilProduct());
//                LinkedHashMap4.put("flowMeterTagNumber", dataOutput.getFlowMeterTagNumber());
//                LinkedHashMap4.put("frontReading", dataOutput.getFrontReading());
//            }
//            if (dataOutput.getReadingDifference() != null) {
//                LinkedHashMap5.put("oilProduct", dataOutput.getOilProduct());
//                LinkedHashMap5.put("flowMeterTagNumber", dataOutput.getFlowMeterTagNumber());
//                LinkedHashMap5.put("readingDifference", dataOutput.getReadingDifference());
//            }
//            if (dataOutput.getFlowMeterRuns() != null) {
//                LinkedHashMap6.put("oilProduct", dataOutput.getOilProduct());
//                LinkedHashMap6.put("flowMeterTagNumber", dataOutput.getFlowMeterTagNumber());
//                LinkedHashMap6.put("flowMeterRuns", dataOutput.getFlowMeterRuns());
//            }
//            if (dataOutput.getOilVolume() != null) {
//                LinkedHashMap7.put("oilProduct", dataOutput.getOilProduct());
//                LinkedHashMap7.put("flowMeterTagNumber", dataOutput.getFlowMeterTagNumber());
//                LinkedHashMap7.put("oilVolume", dataOutput.getOilVolume());
//            }
//            if (MapUtils.isNotEmpty(LinkedHashMap1)) {
//                dataMaps.add(LinkedHashMap1);
//            }
//            if (MapUtils.isNotEmpty(LinkedHashMap2)) {
//                dataMaps.add(LinkedHashMap2);
//            }
//            if (MapUtils.isNotEmpty(LinkedHashMap3)) {
//                dataMaps.add(LinkedHashMap3);
//            }
//            if (MapUtils.isNotEmpty(LinkedHashMap4)) {
//                dataMaps.add(LinkedHashMap4);
//            }
//            if (MapUtils.isNotEmpty(LinkedHashMap5)) {
//                dataMaps.add(LinkedHashMap5);
//            }
//            if (MapUtils.isNotEmpty(LinkedHashMap6)) {
//                dataMaps.add(LinkedHashMap6);
//            }
//            if (MapUtils.isNotEmpty(LinkedHashMap7)) {
//                dataMaps.add(LinkedHashMap7);
//            }
//        }
//        // 1. 中文排序 sort（也可以针对其他字段排序）
//        Collections.sort(dataMaps, (o1, o2) -> {
//            // 取出需要排序的字段
//            String oilProduct = String.valueOf(o1.get("oilProduct"));
//            String flowMeterTagNumber = String.valueOf(o2.get("flowMeterTagNumber"));
//            // 排序
//            Collator instance = Collator.getInstance(Locale.CHINA);
//            // 升序， 参数调换位置就是降序
//            return instance.compare(oilProduct, flowMeterTagNumber);
//        });
//        GetProOilMassFlowMeasurVouFormHairOilOutput output = new GetProOilMassFlowMeasurVouFormHairOilOutput();
//        XCopyUtils.copyObject(entity, output);
//        output.setOilProductList(oilMaps);
//        output.setFlowMeterTagNumberList(tagMaps);
//        output.setAttributeFieldNameList(attributeMaps);
//        output.setOilTagNumberList(dataMaps);
//        return XSingleResult.success(output);
//    }




}
