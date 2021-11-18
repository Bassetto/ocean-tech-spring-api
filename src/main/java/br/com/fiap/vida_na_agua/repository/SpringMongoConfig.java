//package br.com.fiap.vida_na_agua.repository;
//
//import com.mongodb.ConnectionString;
//import org.springframework.context.annotation.*;
//import org.springframework.data.mongodb.core.MongoClientFactoryBean;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//
//@Configuration
//public class SpringMongoConfig {
//
//    @Bean
//    public MongoClientFactoryBean mongoClientFactoryBean() {
//        MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
//            factoryBean.setConnectionString(new ConnectionString("mongodb://localhost:27017/reports?retryWrites=true&w=majority&useNewUrlParser=true&useUnifiedTopology=true"));
//        return factoryBean;
//    }
//
//    public @Bean MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoClientFactoryBean().getObject(), "reports"));
//    }
//
//}
