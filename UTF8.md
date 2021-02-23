##Для корректной работы с UTF-8
###В IntelliJ IDEA
Открыть Help -> Edit custom VM Options и добавить туда строку

```-Dfile.encoding=UTF-8```

###В проекте gradle
Добавить в build.gradle
```
compileJava.options.encoding = 'UTF-8'
compileTestJava.options.encoding = 'UTF-8'
```

###В консоли Windows
Для корректного отображения UTF-8 выполнить команду
```
chcp 65001
```