import net.gdut.bean.TbOrder;
import net.gdut.mapper.TbOrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-mybatis.xml"})
public class ordertest {
    @Autowired
    TbOrderMapper orderMapper;

    @Test
    public void addUserTest(){
        TbOrder tborder = new TbOrder(null,2,1,2);
        orderMapper.addOrder(tborder);
    }
}
