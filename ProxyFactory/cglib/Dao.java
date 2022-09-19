package cglib;

import jdkProxy.annotation.LogAdvice;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
@LogAdvice
public class Dao {

    public void select(String word, String name){
        System.out.println("select is invoked.");
    };
    public void update(){
        System.out.println("update");
    };
    public void save(){
        System.out.println("save");
    };

}
