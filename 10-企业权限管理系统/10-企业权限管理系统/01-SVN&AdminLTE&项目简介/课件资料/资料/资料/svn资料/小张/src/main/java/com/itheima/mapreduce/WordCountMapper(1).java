package com.itheima.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * keyIn 数据输入时的key数据类型，当前业务情况下代表第一行起始偏移量
 * valueIn 数据输入时的value数据类型，当前业务情况下代表读取的这一行的内容
 * keyOut 数据输出时key数据类型，当前业务情况下代表是单词
 * valueOut 数据输出时value数据类型，当前业务情况下代表的是单词出现次数
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();

        String[] words = line.split(" ");

        for(String word:words){
            context.write(new Text(word),new IntWritable(1));
        }
    }
}
