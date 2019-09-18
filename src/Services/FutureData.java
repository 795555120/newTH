package Services;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements Data {

    public FutureData(Callable<RealData> callable){
        super(callable);
    }

    @Override
    public Mydata getContent() {
        Mydata mydata=new Mydata();
        try {
            mydata=get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return mydata;
    }
}
