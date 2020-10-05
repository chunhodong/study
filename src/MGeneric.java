import sun.dc.pr.PRError;

/**
 * 제네릭
   - 여러 타입을 처리할수있는 컬렉션이나 클래스에 컴파일타임 타입체크를 할수있는 기술
   - 제네릭에따라 자동으로 형변환을 해주기때문에 편리성
   - 타입별로 클래스를나 컬렉션을 만들필요없으므로 효율성증가
   - new연산자,static변수에는 사용할수없음, new연산자네 static변수를 사용하는 시점에
     static 변수의 제네릭데이터의 타입이 하나로 정해질수 없기때문
   - static 제네릭메소드는 타입이 아니라 메소드틀을 공유하기때문 사용가능
 * */
public class MGeneric {
}
class GenericList<T>{
    public T value;
    private Object[] elementList = new Object[100];
    public T get(int i){
        return (T)elementList[i];
    }
}