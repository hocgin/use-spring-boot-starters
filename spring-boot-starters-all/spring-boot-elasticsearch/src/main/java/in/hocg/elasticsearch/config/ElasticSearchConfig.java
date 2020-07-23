package in.hocg.elasticsearch.config;

import lombok.AllArgsConstructor;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by hocgin on 2019/3/21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Configuration
@AllArgsConstructor
public class ElasticSearchConfig {

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        return new PreBuiltXPackTransportClient(Settings.builder()
                .put("cluster.name", "elasticsearch_hocgin")
                .put("xpack.security.user", "elastic:changeme")
                .build())
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }
}
