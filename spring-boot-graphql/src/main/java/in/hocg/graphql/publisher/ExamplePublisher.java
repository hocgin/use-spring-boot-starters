package in.hocg.graphql.publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by hocgin on 2019-07-22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Component
public class ExamplePublisher {
    private final Flowable<DataWrapper> publisher;
    
    public ExamplePublisher() {
        // 每个一秒制造一个通知，并进行发送
        // 如果实现其他事件或处理可以在这里补充
        Observable<DataWrapper> o = Observable.interval(1, 1, TimeUnit.SECONDS)
                .map(l -> new DataWrapper().setData(l.toString()));
        ConnectableObservable<DataWrapper> co = o.share().publish();
        co.connect();
        publisher = co.toFlowable(BackpressureStrategy.BUFFER);
    }
    
    public Flowable<DataWrapper> getPublisher() {
        return publisher;
    }
}
