import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 스트림
 - 데이터의 흐름,기존에 컬렉션이나 배열에 있는 데이터를 스트림이라는 데이터흐름으로 추상화시킴
 - 스트림속에서 데이터를 처리할수 있음, 여러 스레드를 이용해 데이터를 병렬처리할 수 있음
 - 데이터를 immutable한 상태로 유지할수 있음
 * */
public class MStream {
    private int caloiries;

    private String name;

    public MStream(int caloiries,String name){
        this.caloiries = caloiries;
        this.name = name;
    }

    public int getCaloiries() {
        return caloiries;
    }

    public void setCaloiries(int caloiries) {
        this.caloiries = caloiries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeStream(){
        String[] arr = new String[]{"a","b","c"};
        
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

    }
    public static void main(String[]args){
        System.out.println("hi");
        List<MStream> mStreamList = new ArrayList<MStream>();
        mStreamList.add(new MStream(500,"고기"));
        mStreamList.add(new MStream(100,"과일"));

        List<Integer> mStreams = mStreamList
                .stream()
                .filter(s->s.getCaloiries() > 300)
                .map(MStream::getCaloiries)
                .collect(Collectors.toList());


    }
}
