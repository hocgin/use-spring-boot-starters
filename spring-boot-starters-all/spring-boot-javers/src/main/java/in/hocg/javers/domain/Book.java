package in.hocg.javers.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
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
@Entity(name = "t_book")
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, updatable = false)
    private Long authorId;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.OFF;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @CreatedBy
    private String creator;
    
    @LastModifiedBy
    private String modifier;
    
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    
    
    public enum Status {
        // 是否上架
        ON,
        OFF
    }
}
