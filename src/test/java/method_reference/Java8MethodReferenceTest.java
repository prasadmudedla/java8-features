package method_reference;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Java8MethodReferenceTest {
    static List<String> list;

    @BeforeAll
    public void init() {
        list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");
    }


    /*
        The reference to a static method holds the following syntax: ContainingClass::methodName.

        Lambda expression in the anyMatch() method just makes a call to a static method isRealUser(User user)
            of the User class. So it can be substituted with a reference to a static method
    */
    @Test
    public void checkStaticMethodReferences() {

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());

        boolean isReal = users.stream().allMatch(u -> User.isRealUser(u));
        boolean isRealRef = users.stream().allMatch(User::isRealUser);

        assertTrue(isReal);
        assertTrue(isRealRef);
    }


    /*
        The reference to an instance method holds the following syntax: containingInstance::methodName.
            Following code calls method isLegalName(String string) of type User which validates an input parameter
     */
    @Test
    public void checkInstanceMethodReferences() {

        User user = new User();

        boolean isLegalName = list.stream().anyMatch(user::isLegalName);

        assertTrue(isLegalName);
    }


    /*
        This reference method takes the following syntax: ContainingType::methodName
     */
    @Test
    public void checkParticularTypeReferences() {

        long count = list.stream().filter(String::isEmpty).count();

        assertEquals(count,2);
    }


    /*
        A reference to a constructor takes the following syntax: ClassName::new.
            As constructor in Java is a special method,
                method reference could be applied to it too with the help of new as a method name
     */
    @Test
    public void checkConstructorReferences() {

        Stream<User> stream = list.stream().map(User::new);
        List<User> userList = stream.collect(Collectors.toList());

        assertEquals(userList.size(), list.size());
        assertTrue(userList.get(0) instanceof User);
    }






}
