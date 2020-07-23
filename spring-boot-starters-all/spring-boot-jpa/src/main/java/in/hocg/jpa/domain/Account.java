package in.hocg.jpa.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019-09-21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Entity(name = "t_account")
@EntityListeners(AuditingEntityListener.class)
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, updatable = false)
    private String name;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "json")
    private String settings = "{}";
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
