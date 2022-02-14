wget https://dlcdn.apache.org/spark/spark-3.2.1/spark-3.2.1-bin-hadoop3.2.tgz
ls
tar -xzvf spark-3.2.1-bin-hadoop3.2.tgz 
sudo apt update
sudo apt install openjdk-11-jdk

export SPARK_HOME=$PWD/spark-3.2.1-bin-hadoop3.2
export PATH=$PATH:$SPARK_HOME/bin
export PATH=$PATH:$SPARK_HOME/sbin
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64

start-worker.sh spark://0e9fdd096c1c.mylabserver.com:7077

usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/home/cloud_user/spark-3.2.1-bin-hadoop3.2/spark-3.2.1-bin-hadoop3.2/bin:/home/cloud_user/spark-3.2.1-bi
n-hadoop3.2/sp