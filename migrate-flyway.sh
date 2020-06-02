#! /bin/bash
# author:tangel

#执行jooq相关命令--生成jooq等文件
#考虑点
# 1、更新表结构，同时更新jooq文件
function execJooq() {
  #删除之前的文件，重新执行生成新的文件
  mvn clean compile
}

function delJooq() {
  rm -rf /Users/ganguo/project_my/springboot-jooq-flyway/src/main/java/generated_jooq
}

#执行flyway相关命令--操作数据库

#考虑点
# 1、更新表结构，保留数据记录（更新默认数据）
# 2、更新表结构，不保留数据记录，全部更新（更新默认数据）
function execFlyway() {
  #重新进行migrate
  mvn flyway:migrate
}
function delFlyWay() {
  mvn flyway:clean
}

#
# 命令规范执行
#   ./gradlew flywayClean flywayMigrate jooqClean jooq
#   1、参数flywayMigrate = 执行执行更新数据库
#   2、

#接收界面传输的参数信息
prop1=$1
prop2=$2
prop3=$3
prop4=$4
echo "第一个参数" $prop1
echo "第二个参数" $prop2
echo "第三个参数" $prop3
echo "第四个参数" $prop4

array_prop=($prop1 $prop2 $prop3 $prop4)

# shellcheck disable=SC2068
echo "数组参数 :" ${array_prop[@]}

#执行逻辑之前，考虑执行顺序，flyway的执行

#
#   flywayMigrate存在，判断flywayClean是否存在
#       1、存在，先执行flywayClean，后执行flywayMigrate
#       2、不存在,直接执行flywayMigrate
#
existFlyway=false
existFlywayClean=false
existJooq=false
existJooqClean=false
# shellcheck disable=SC2068
for i in ${array_prop[@]}; do
  if [ $i == "flywayClean" ]; then
    existFlywayClean=true
  fi
  if [ $i == "flywayMigrate" ]; then
    existFlyway=true
  fi
  if [ $i == "jooqClean" ]; then
    existJooqClean=true
  fi
  if [ $i == "jooq" ]; then
    existJooq=true
  fi
done

function flyway() {
  if [ $existFlyway == true ]; then
    if [ $existFlywayClean == true ]; then
      #先执行删除数据库结构和数据，后执行更新数据库表结构
      echo "先执行删除数据库结构和数据，后执行更新数据库表结构"
      delFlyWay
      execFlyway
    elif [ $existFlywayClean == false ]; then
      echo "直接更新数据库表结构"
      execFlyway
    fi
  elif [ $existFlyway == false ]; then
    if [ $existFlywayClean == true ]; then
      echo "清除数据库表结构"
      delFlyWay
    fi
  fi
}

function jooq() {
  if [ $existJooq == true ]; then
    if [ $existJooqClean == true ]; then
      #先删除jooq生成的代码，后重新生成jooq代码
      echo "先删除jooq生成的代码，后重新生成jooq代码"
      deldJooq
      execJooq
    elif [ $existJooqClean == false ]; then
      #直接生成jooq代码
      echo "直接生成jooq代码"
      execJooq
    fi
  elif [ $existJooq == false ]; then
    if [ $existJooqClean == true ]; then
      echo "清除Jooq文件"
      deldJooq
    fi
  fi
}

#执行顺序，先操作数据库，再操作jooq
flyway
jooq
