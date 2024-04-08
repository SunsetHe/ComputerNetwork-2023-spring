package New.Week13;

public class PersonB implements IProxy{
    private IProxy m_person;

    PersonB(IProxy person){
        m_person = person;
    }

    @Override
    public void submit() {
        before();
        m_person.submit();
    }

    public void before(){
        System.out.println("PersonB加上抬头");
    }
}
