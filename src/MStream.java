import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
