package lib;

import dao.DaoOrder;
import dao.DaoProduct;
import dao.DaoShoppingCart;
import dao.DaoUser;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            if (f.getAnnotation(Inject.class) != null) {
                Class interfacesFild = f.getType();
                if (interfacesFild.equals(DaoShoppingCart.class)) {
                    f.setAccessible(true);
                    Reflections reflections = new Reflections("daoImpl");
                    Set<Class<?>> subtypes =  reflections.getTypesAnnotatedWith(DaoInjectShoppingCart.class);
                    Class newClazz = subtypes.iterator().next();


                    Constructor constructor1 = newClazz.getDeclaredConstructor();
                    Object instance1 = constructor1.newInstance();
                    f.set(instance, constructor1.newInstance());
                }
                if (interfacesFild.equals(DaoUser.class)) {
                    f.setAccessible(true);
                    Reflections reflections = new Reflections("daoImpl");
                    Set<Class<?>> subtypes =  reflections.getTypesAnnotatedWith(DaoInjectUser.class);
                    Class newClazz = subtypes.iterator().next();


                    Constructor constructor1 = newClazz.getDeclaredConstructor();
                    Object instance1 = constructor1.newInstance();
                    f.set(instance, constructor1.newInstance());
                }

                if (interfacesFild.equals(DaoOrder.class)) {
                    f.setAccessible(true);
                    Reflections reflections = new Reflections("daoImpl");
                    Set<Class<?>> subtypes =  reflections.getTypesAnnotatedWith(DaoInjectOrder.class);
                    Class newClazz = subtypes.iterator().next();


                    Constructor constructor1 = newClazz.getDeclaredConstructor();
                    Object instance1 = constructor1.newInstance();
                    f.set(instance, constructor1.newInstance());
                }
                if (interfacesFild.equals(DaoProduct.class)) {
                    f.setAccessible(true);
                    Reflections reflections = new Reflections("daoImpl");
                    Set<Class<?>> subtypes =  reflections.getTypesAnnotatedWith(DaoInjectProduct.class);
                    Class newClazz = subtypes.iterator().next();


                    Constructor constructor1 = newClazz.getDeclaredConstructor();
                    Object instance1 = constructor1.newInstance();
                    f.set(instance, constructor1.newInstance());
                }

            }
        }
        return instance;
    }
}
