package com.itheima.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * reduce阶段处理的类，
 * keyin reduce阶段输入的key类型，对应mapper阶段输出的key类型    Text
 * valuein  reduce阶段输入的value类型，对应mapper阶段输出的value类型  IntWriteable
 * keyout  reduce阶段输出的key类型，就是单词   Text
 * valueout  reduce阶段输出的value类型，就是单词出现的次数   IntWriteable
 */
public class WordCountReduce extends Reducer<Text,IntWritable,Text,IntWritable>{

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int count=0;
        for(IntWritable c:values){
            count+=c.get();
        }
        context.write(key,new IntWritable(count));
    }
}
