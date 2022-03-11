#### MySQL

​		  MySQL DDL 定义了数据定义语言，它是四个 SQL 命令的子组：`DDL`、`DML`、`DCL`、`TCL`。因为，结构化查询语言（SQL）是数据库的基本语言，它在可用的 MySQL 数据库中执行不同的操作和查询，包括创建数据库或表以删除相同的数据库或表以及更新、插入等其他操作。MySQL DDL 涉及数据库的模式和解释，以显示数据库数据应如何存在于服务器中。DDL 命令对于表达和改变数据库表、模式或对象的结构具有重要意义。当 MySQL 中使用 DDL 命令的语句被执行时，即刻生效。

##### DDL：

​		（Data Definition Language）数据库定义语言，用于数据的结构和模式。

###### 1. CREATE

​		此 DDL 命令用于创建具有不同对象的任何数据库，例如表、索引、触发器、视图、存储过程、内置函数等。

```sql
CREATE DATABASE my_database;
CREATE TABLE my_table
(
    ID            INT PRIMARY KEY NOT NULL COMMENT '主键',
    NAME          VARCHAR(20)     NOT NULL COMMENT '姓名',
    AGE           INT             NOT NULL COMMENT '年龄',
    CREATE_USER   VARCHAR(20)     NOT NULL COMMENT '创建用户',
    MODIFIED_USER VARCHAR(20) COMMENT '修改用户',
    CREATE_DATE   DATE            NOT NULL COMMENT '创建时间',
    MODIFIED_DATE DATE COMMENT '修改时间'
)
```



​			



###### 2. ALTER 命令

ALTER DDL 命令用于修改当前数据库和相关表的结构。

使用 Alter 查询，我们可以添加、更改或删除表上的当前约束或表上的列。语法如下所述：

**代码：**

```
ALTER TABLE TableName ADD ColumnName Data_Type;
ALTER TABLE TableName DROP ColumnName;
ALTER TABLE TableName MODIFY COLUMN ColmnName Data_Type;
```

让我们使用上述结构执行一些查询：

**代码：**

```
ALTER TABLE Emp ADD Emp_Contact INT NOT NULL;
```

**输出：**

![改变](https://cdn.educba.com/academy/wp-content/uploads/2020/08/MySQL-DDL-3.png.webp)

**代码：**

```
ALTER TABLE Emp DROP Emp_Contact;
```

**输出：**

![MySQL DDL - 4](https://cdn.educba.com/academy/wp-content/uploads/2020/08/MySQL-DDL-4.png.webp)

**代码：**

`select * from emp`

**输出：**

![MySQL DDL - 5](https://cdn.educba.com/academy/wp-content/uploads/2020/08/MySQL-DDL-5.png.webp)

**代码：**

```
ALTER TABLE Emp MODIFY COLUMN Emp_Adm DateYear;
```

**输出：**

![MySQL DDL - 6](https://cdn.educba.com/academy/wp-content/uploads/2020/08/MySQL-DDL-6.png.webp)

###### 3. DROP 命令

此 MySQL 命令用于删除数据库对象。简而言之，使用 drop 查询语法删除数据库中存在的表：

**代码：**

```
DROP TABLE TableName;
```

**代码：**

```
DROP Table Emp;
```

**输出：**

![降低](https://cdn.educba.com/academy/wp-content/uploads/2020/08/MySQL-DDL-7.png.webp)

我们需要知道，在执行 DROP 命令时要小心，因为它会导致存储在表中的数据记录丢失。

###### 4. TRUNCATE 命令

截断 DDL 命令用于从数据库表中删除所有数据行，包括删除为这些表记录分配的所有空格。

**代码：**

TRUNCATE 命令的语法与 DROP 语句相同，如下所示：

```
TRUNCATE TABLE TableName;
```

假设，我们在下面的查询中使用上述命令：

**代码：**

```
TRUNCATE TABLE Emp;
```

**输出：**

![截短](https://cdn.educba.com/academy/wp-content/uploads/2020/08/MySQL-DDL-8.png.webp)

输出表明截断只会删除特定表中的记录，而不是数据库本身中的表。

###### 5. COMMENT 命令

此 Comment 查询有利于将所需的注释添加到 MySQL 服务器中的数据字典中。

通常，MySQL 中的注释用于描述语句的部分或避免执行查询语句。