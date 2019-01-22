package com.mycloud.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisPlusGenerator {
	public static void main(String[] args) throws InterruptedException {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
      //项目名称
        String workspace="E://WORKSPACE//java-workspace//mycloud-admin//mycloud-admin//mycloud-modules//";
        String outputDir = "mycloud-user";
        gc.setOutputDir(workspace+outputDir+"/src/main/java");
        gc.setFileOverride(true);//是否重写文件
        //gc.setActiveRecord(true);//
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("HOU");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        //gc.setMapperName("%sDao");
        gc.setMapperName("I%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        /*dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });*/

        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://192.168.52.147:3306/mycloud-admin?useUnicode=true&characterEncoding=UTF-8&tinyInt1isBit=true");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);



        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        /*是否使用lombok*/
        strategy.setEntityLombokModel(true);
        //strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略

        String[] table = new String[] {"account_roles"};
        strategy.setInclude(table); // 需要生成的表
        strategy.setRestControllerStyle(true);//生成restful的controller
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setDbColumnUnderline(false);
        strategy.setSuperEntityClass("com.mycloud.common.base.BaseEntity");
//      strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        //父类中的字段
        strategy.setSuperEntityColumns(new String[]{"id","create_time","update_time","create_by","update_by","is_del"});
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setExclude(new String[]{"order"}); // 排除生成的表
        strategy.setEntityBuilderModel(true);
        strategy.setLogicDeleteFieldName("is_del");//逻辑删除字段名称
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.mycloud.user");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值

 		InjectionConfig cfg = new InjectionConfig() {
 			@Override
 			public void initMap() {
 				Map<String, Object> map = new HashMap<String, Object>();
 				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
 				this.setMap(map);
 			}
 		};
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		focList.add(new FileOutConfig("templates/entity.java.vm") {

			@Override
			public String outputFile(com.baomidou.mybatisplus.generator.config.po.TableInfo tableInfo) {
				// TODO Auto-generated method stub
				return "E://gemcode//my_" + tableInfo.getEntityName() + ".java";
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
		// 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：

		TemplateConfig tc = new TemplateConfig();
		//tc.setController("...");

		tc.setEntity("templates/entity.java.vm");

		//tc.setXml("...");

		tc.setService("templates/service.java.vm");

		tc.setMapper("templates/mapper.java.vm");
		tc.setServiceImpl("templates/serviceImpl.java.vm");
		mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();
	     // 打印注入设置
	    System.err.println(mpg.getCfg().getMap().get("abc"));
	    System.exit(0);
    }
}
