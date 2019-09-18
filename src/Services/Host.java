package Services;

import java.util.concurrent.Callable;

public class Host {
    public FutureData request(String filename, int start, int end, int skip){
//        System.out.println("    request("+count+", "+c+") BEGIN");

        //1、创建FutureData的实例
        FutureData future=new FutureData(
                new Callable<RealData>(){

                    @Override
                    public RealData call() throws Exception {
                        return new RealData(filename,start,end,skip);
                    }
                }
        );

        new Thread(future).start();

//        System.out.println("    request(\"+count+\", \"+c+\") END");

        return future;
    }
}
