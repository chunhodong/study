package aop;

import java.util.List;


/**
 * 비즈니스 로직만 담은 UserService Interface 구현 오브젝트
 * */
public class UserServiceImpl implements  UserService{
    UserDao userDao;
    MailSender mailSender;


    /**
     * 트랜잭션 코드가 없는 순수 비즈니스로직
     * */
    @Override
    public void add(User user) {

    }

    /**
     * 트랜잭션 코드가 없는 순수 비즈니스로직
     * */
    @Override
    public void upgradeLevels() {
    }

    public boolean canUpgradeLevel(User user){
        return true;
    }
    public void upgradeLevel(User user){

    }
}
