import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

public class ClassPrinter {
    private static final ArrayList<Method> methods = new ArrayList<>();
    private static final ArrayList<Field> fields = new ArrayList<>();
    private static final HashSet<Class<?>> interfaces = new HashSet<>();
    private static final ArrayList<Constructor<?>> constructors = new ArrayList<>();
    private static final HashSet<Class<?>> secondary = new HashSet<>();

    public static void print(Class<?> cls, boolean print_subclass) {
        //Class<?> cls = obj.getClass();
        printSuper(cls);
        clear(print_subclass);
        constructors.addAll(Arrays.asList(cls.getDeclaredConstructors()));
        fillData(cls);
        if (!interfaces.isEmpty()) {
            System.out.print("implements ");
            for(Class<?> intrf : interfaces) {
                System.out.print(intrf.getName() + " ");
            }
            System.out.println();
        }
        System.out.println("========================================================");
        System.out.println("Constructors:");
        for(Constructor<?> constructor : constructors) {
            printModifiers(constructor.getModifiers());
            System.out.print(constructor.getName());
            printParams(constructor.getParameters());
        }
        System.out.println("========================================================");
        System.out.println("Fields:");
        for (Field field : fields) {
            printType(field.getGenericType(), field.getType(), true, print_subclass);
            System.out.println(field.getName());
        }
        System.out.println("========================================================");
        System.out.println("Methods:");
        for (Method method : methods) {

            printModifiers(method.getModifiers());
            printType(method.getGenericReturnType(), method.getReturnType(), false, print_subclass);
            System.out.print(method.getName());
            printParams(method.getParameters());
        }
        if (print_subclass && !secondary.isEmpty()) {
            System.out.println("===========================Secondary classes===========================");
            for (Class<?> clas : secondary) {
                print(clas, false);
            }
        }
    }

    private static void printType(Type type, Class<?> cls, boolean is_field, boolean print_subclass) {
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType) type;
            Type[] params = ptype.getActualTypeArguments();
            System.out.print(cls.getSimpleName() + "<");
            System.out.print(Arrays.stream(params).map(Type::getTypeName).collect(Collectors.joining(", ")));
            System.out.print("> ");
        } else {
            System.out.print(cls.getSimpleName() + " ");
        }
        if (Collection.class.isAssignableFrom(cls) ||
                Map.class.isAssignableFrom(cls)) {
            System.out.print("/*This is Collection*/ ");
        } else {
            if(print_subclass && is_field && !cls.isPrimitive()){
                secondary.add(cls);
            }
        }
    }

    private static void printModifiers(int mod) {
        if ((mod & Modifier.PUBLIC) != 0) {
            System.out.print("public ");
        }
        if ((mod & Modifier.PRIVATE) != 0) {
            System.out.print("private ");
        }
        if ((mod & Modifier.PROTECTED) != 0) {
            System.out.print("protected ");
        }
        if ((mod & Modifier.STATIC) != 0) {
            System.out.print("static ");
        }
        if ((mod & Modifier.FINAL) != 0) {
            System.out.print("final ");
        }
        if ((mod & Modifier.SYNCHRONIZED) != 0) {
            System.out.print("synchronized ");
        }
        if ((mod & Modifier.VOLATILE) != 0) {
            System.out.print("volatile ");
        }
        if ((mod & Modifier.TRANSIENT) != 0) {
            System.out.print("transient ");
        }
        if ((mod & Modifier.NATIVE) != 0) {
            System.out.print("native ");
        }
        if ((mod & Modifier.INTERFACE) != 0) {
            System.out.print("interface ");
        }
        if ((mod & Modifier.ABSTRACT) != 0) {
            System.out.print("abstract ");
        }
        if ((mod & Modifier.STRICT) != 0) {
            System.out.print("strict ");
        }
    }

    private static void printParams(Parameter[] params) {
        System.out.print("(");
        System.out.print(Arrays.stream(params)
                .map(p -> p.getType().getSimpleName())
                .collect(Collectors.joining(", ")));
        System.out.println(")");
    }

    private static void clear(boolean print_subclass) {
        methods.clear();
        fields.clear();
        interfaces.clear();
        if (print_subclass) {
            secondary.clear();
        }
        constructors.clear();
    }

    private static void fillData(Class<?> cls) {
        fields.addAll(Arrays.asList(cls.getDeclaredFields()));
        methods.addAll(Arrays.asList(cls.getDeclaredMethods()));
        interfaces.addAll(Arrays.asList(cls.getInterfaces()));
        Class<?> superclass = cls.getSuperclass();
        if (superclass != null) {
            fillData(superclass);
        }
    }

    private static void printSuper(Class<?> cls) {
        //Class<?> cls = obj.getClass();
        System.out.println("================================================================");
        System.out.println(cls.getSimpleName() + " class description");
        System.out.println("================================================================");
        System.out.println("Hierarchy:");
        System.out.println(cls.getSimpleName());
        int i = 1;
        for (Class<?> sup = cls.getSuperclass(); sup != null; sup = sup.getSuperclass(), i++) {
            for(int j = 0; j < i; j++) {
                System.out.print('\t');
            }
            System.out.println("extends " + sup.getSimpleName());
        }
    }
}
