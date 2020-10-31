package aop;

/**
 * 프록시클래스
 * - 타깃클래스와 같은 인터페이스를 구현
 * - 프록시클래스가 타깃클래스를 제어할수 있음
 * - 클래스로 프록시를 만들경우, 부가기능마다 클래스를 만들어줘야함(안만들순있지만 단일책임원칙위반)
 * - 구현해야할 인터페이스 메소드가 많은수록 개발자가 일일이 구현해야함(부가기능이 필요없는 기능포함)
 * - 부가기능코드가 중복될수있음(ex: add,update에는 전부 트랜잭션작업이들어감)
 * */
public class UserServiceTx implements UserService{

    UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }

    /**
     * 비즈니스로직은 UserServiceImpl에 위임할수있다
     * */
    @Override
    public void add(User user) {
        userService.add(user);
    }

    /**
     * 비즈니스로직은 UserServiceImpl에 위임할수있다
     * */
    @Override
    public void upgradeLevels() {
        userService.upgradeLevels();
    }
}
