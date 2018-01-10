package com.lifecircle.ui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/11/15.
 */
public class MyInfoBean {

    /**
     * data : {"data":[{"id":"111","name":"陈朝晖","topic_firstid":"17","topic_img":"http://p0scl3b39.bkt.clouddn.com/a5dc4201712221819503805.jpg,http://p0scl3b39.bkt.clouddn.com/a9193201712221819519875.jpg,http://p0scl3b39.bkt.clouddn.com/a0b73201712221819535718.jpg,http://p0scl3b39.bkt.clouddn.com/afd8e20171222182032990.jpg","topic_content":"求职招聘\n找个大力士","topic_time":"1513937990","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-22","topic_title":"你猜我现在在干什么","column_name":"求职招聘","note_id":"111","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic","comment_content":"太饿了","source":"0","note_title":"冬至","note_img":"","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"今天是冬至，大家要吃饺子啊\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5e56e201712221808138946.jpg\",\"num\":\"1\"}]}","note_like":"0","note_comment":"3","uid":"84","note_columnid":"21","note_time":"1513314550","likeed_id":"84","followed_is":0,"reply_id":"38","reply_content":"这是对帖子的第一条评论","reply_name":"陈朝晖","replyed_uid":"69"},{"id":"110","name":"陈朝晖","topic_firstid":"10","topic_img":"http://p0scl3b39.bkt.clouddn.com/c0170201712221812102796.jpg","topic_content":"冬至吃饺子","topic_time":"1513937530","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-22","topic_title":"我是话题测试2","column_name":"爆料","note_id":"110","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"46","name":"陈朝晖","comment_content":"太饿了","source":"0","note_id":"50","time":"2017-12-22","note_title":"冬至","note_img":"","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"45","name":"陈朝晖","comment_content":"好啊好啊","source":"0","note_id":"50","time":"2017-12-22","note_title":"冬至","note_img":"","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"44","name":"陈朝晖","comment_content":"今天要吃饺子","source":"0","note_id":"50","time":"2017-12-22","note_title":"冬至","note_img":"","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"50","note_title":"冬至","name":"陈朝晖","note_img":"","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"今天是冬至，大家要吃饺子啊\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5e56e201712221808138946.jpg\",\"num\":\"1\"}]}","note_like":"0","note_comment":"3","time":"2017-12-22","column_name":"求职招聘","note_id":"50","type_data":"note","is_like":0,"like_list":[],"comment_list":[{"id":"44","uid":"69","comment_content":"今天要吃饺子","comment_time":"2017-12-22","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[]},{"id":"45","uid":"69","comment_content":"好啊好啊","comment_time":"2017-12-22","num":"2","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"2楼","dignity":"楼主","reply":[]},{"id":"46","uid":"69","comment_content":"太饿了","comment_time":"2017-12-22","num":"3","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"3楼","dignity":"楼主","reply":[]}],"dataType":"note"},{"id":"49","note_title":"收废品","name":"陈朝晖","note_img":"","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"回收旧电器 洗衣机 烂冰箱 烂彩电 烂空调 烂电瓶回收～\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/ca4fb2017122217335574.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"回收旧电器 洗衣机 烂冰箱 烂彩电 烂空调 烂电瓶回收～回收旧电器 洗衣机 烂冰箱 烂彩电 烂空调 烂电瓶回收～\",\"num\":\"2\"}]}","note_like":"0","note_comment":"0","time":"2017-12-22","column_name":"周边服务","note_id":"49","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"43","name":"陈朝晖","comment_content":"哈哈","source":"0","note_id":"34","time":"2017-12-22","note_title":"我发的","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"33","note_title":"图解了","uid":"84","name":"等阳荒芜了时光","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"\",\"num\":\"0\"}]}","note_columnid":"21","note_time":"1513314550","note_like":"2","note_comment":"0","time":"2017-12-21","column_name":"求职招聘","note_id":"33","type_data":"note","is_like":0,"likeed_id":"84","dataType":"like"},{"id":"48","note_title":"房屋租售的帖子","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"我的人家，你的时候你们\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/e3b23201712211543011343.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"我们都市全部的生活了？你说过于执着地说、一定程度的话，我的人家的确如此，我的人家的确如此，我们都会觉得你是因为有人在一起\",\"num\":\"2\"}]}","note_like":"0","note_comment":"0","time":"2017-12-21","column_name":"房屋租售","note_id":"48","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"34","note_title":"我发的","uid":"69","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"1发帖了\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/66fcc201712151435452439.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"我们的确很鬼故事还是说睡觉睡觉是实话实说公司 v 是 v 是 v 是个实话实说睡觉睡觉了，我们的确是不是要把它当作一个人在一起吧嗒。我的第一时间想到的是什么意思。我的第一时间想到的是我最后的话。我们都市田园风光。我的第一时间想到的是什么意思。我们都会觉得你是不是在一起了。我的第一时间想到的是什么意思。我的第一时间想到的是什么意思。我的第一时间想到的是什么广告或者生生世世好多好多好多好多浩浩荡荡好实话实说说好多话好多\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/15581201712151436595320.mp4\",\"num\":\"3\"}]}","note_columnid":"21","note_time":"1513319829","note_like":"1","note_comment":"1","time":"2017-12-21","column_name":"求职招聘","note_id":"34","type_data":"note","is_like":0,"likeed_id":"69","dataType":"like"},{"id":"109","name":"陈朝晖","uid":"69","topic_firstid":"11","topic_img":"http://p0scl3b39.bkt.clouddn.com/dab7620171220182201607.jpg","topic_content":"我","topic_time":"1513765321","topic_link":"","topic_address":"我的位置","topic_like":"1","topic_comment":"0","time":"2017-12-20","topic_title":"我们都是周边服务的话题","column_name":"爆料","note_id":"109","type_data":"topic","is_like":0,"likeed_id":"69","followed_is":0,"dataType":"like"},{"id":"109","name":"陈朝晖","topic_firstid":"11","topic_img":"http://p0scl3b39.bkt.clouddn.com/dab7620171220182201607.jpg","topic_content":"我","topic_time":"1513765321","topic_link":"","topic_address":"我的位置","topic_like":"1","topic_comment":"0","time":"2017-12-20","topic_title":"我们都是周边服务的话题","column_name":"爆料","note_id":"109","type_data":"topic","is_like":0,"like_list":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment_list":[],"dataType":"topic"},{"id":"47","note_title":"我厄尔","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"法院官方发发的\",\"num\":\"0\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/4424a201712201619173388.mp4\",\"num\":\"1\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/6260c201712201619247148.mp4\",\"num\":\"2\"},{\"type\":\"text\",\"info\":\"你们是因为自己太多了。我\",\"num\":\"3\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/c768b201712201619339694.jpg\",\"num\":\"4\"},{\"type\":\"text\",\"info\":\"\",\"num\":\"0\"},{\"type\":\"text\",\"info\":\"是否会回复\",\"num\":\"1\"}]}","note_like":"0","note_comment":"0","time":"2017-12-20","column_name":"爆料","note_id":"47","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"108","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/8a2c2201712201520135504.jpg","topic_content":"我的人生","topic_time":"1513754413","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-20","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"108","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"46","note_title":"我","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"你\",\"num\":\"0\"}]}","note_like":"0","note_comment":"0","time":"2017-12-20","column_name":"爆料","note_id":"46","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"107","name":"陈朝晖","topic_firstid":"7","topic_img":"","topic_content":"我的人","topic_time":"1513754336","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-20","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"107","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"95","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/43fcf201712201026224307.jpg","topic_content":"我","topic_time":"1513736782","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-20","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"95","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"94","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/d371f20171220102434602.jpg","topic_content":"粉丝高高瘦瘦的互动对话大好河山","topic_time":"1513736674","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-20","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"94","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"45","note_title":"我的","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"你的时候就会觉得\",\"num\":\"0\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/2cdf5201712201023269402.mp4\",\"num\":\"1\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/1d3d8201712201023323756.jpg\",\"num\":\"2\"}]}","note_like":"0","note_comment":"0","time":"2017-12-20","column_name":"爆料","note_id":"45","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"93","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/3cf9920171219180048856.jpg","topic_content":"我发的话题","topic_time":"1513677648","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"93","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"92","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/7e03220171219175930806.jpg","topic_content":"我的人家的确是","topic_time":"1513677570","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"92","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"91","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/44e77201712191759003324.jpg","topic_content":"我的人生态度，你的时候你","topic_time":"1513677540","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"91","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"32","note_title":"陈朝晖在求职招聘中发的帖子","uid":"69","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"11111111\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/afcec201712141701025325.jpg\",\"num\":\"1\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5fe17201712141701096113.jpg\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/aa1a3201712141701234864.mp4\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"我222222\",\"num\":\"4\"}]}","note_columnid":"21","note_time":"1513242103","note_like":"1","note_comment":"1","time":"2017-12-19","column_name":"求职招聘","note_id":"32","type_data":"note","is_like":0,"likeed_id":"69","dataType":"like"},{"id":"70","name":"陈朝晖","uid":"69","topic_firstid":"7","topic_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","topic_time":"1512700728","topic_link":"","topic_address":"我的位置","topic_like":"1","topic_comment":"3","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"70","type_data":"topic","is_like":0,"likeed_id":"69","followed_is":0,"dataType":"like"},{"id":"38","name":"陈朝晖","comment_content":"这是对帖子的第一条评论","source":"0","note_id":"32","time":"2017-12-19","note_title":"陈朝晖在求职招聘中发的帖子","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","likeed_id":"69","followed_is":0,"dataType":"like"},{"id":"39","name":"陈朝晖","comment_content":"回复一楼","source":"0","note_id":"32","reply_id":"38","time":"2017-12-19","reply_content":"这是对帖子的第一条评论","reply_name":"陈朝晖","replyed_uid":"69","followed_is":0,"note_title":"陈朝晖在求职招聘中发的帖子","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","likeed_id":"69","dataType":"like"},{"id":"34","name":"陈朝晖","comment_content":"二楼评论","source":"1","note_id":"70","time":"2017-12-19","note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","likeed_id":"69","followed_is":0,"dataType":"like"},{"id":"90","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/c7761201712190943528962.jpg","topic_content":"我","topic_time":"1513647832","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"90","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"79","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/96318201712181535123048.jpg","topic_content":"请问巍巍峨峨","topic_time":"1513582512","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"79","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"78","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/07388201712181534221810.jpg","topic_content":"请问巍巍峨峨","topic_time":"1513582462","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"78","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"75","name":"陈朝晖","topic_firstid":"7","topic_img":"/upload/20171218/4e36c918afafc8b9a7fbbbbb8a2851c0.jpg","topic_content":"我","topic_time":"1513580406","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"75","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"74","name":"陈朝晖","topic_firstid":"7","topic_img":"/upload/20171218/1843972def93f14557f11698aafddf70.jpg,/upload/20171218/faba7cb85c62ea61392cf3b7ad266755.jpg,/upload/20171218/ae7a4a58f2ed56fed279cd7fd758ce00.jpg,/upload/20171218/fcb542afd98d296f51cb3b3d1ec12486.jpg","topic_content":"发布帖子\n啦啦啦啦啦啦啦啦啦啦啦","topic_time":"1513580277","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"74","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"73","name":"陈朝晖","topic_firstid":"7","topic_img":"/upload/20171218/3d580ba64721b2bc5b03df0e8b822966.jpg,/upload/20171218/b5bd08a681bdf8f577c65de1b679ddd7.jpg,/upload/20171218/b85f4ea36467d8ca4b706beeb379de35.jpg,/upload/20171218/01754f8e3ed0ba2e8dc33ffea956545a.jpg","topic_content":"分享话题测试\n啦啦啦啦啦啦啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦啦","topic_time":"1513579956","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"73","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"37","note_title":"这是爆料的帖子","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"陈朝晖发的\",\"num\":\"0\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/aa13c201712161813013142.mp4\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"多写点内容是什么时候开始喜欢上了大学之后我的小时候玩儿了。我们在一起时候就坐不会去皮洗脑的话可以接受你的心是否还有机会赢取三星手机的日子也要注意了？我是多写点内容是什么时候开始喜欢上了大学之后我的小时候玩儿了。我们在一起时候就坐不会去皮洗脑的话可以接受你的心是否还有机会赢取三星手机的日子也要注意了？我是多写点内容是什么时候开始喜欢上了大学之后我的小时候玩儿了。我们在一起时候就坐不会去皮洗脑的话可以接受你的心是否还有机会赢取三星手机的日子也要注意了？我是\\n多写点内容是什么时候开始喜欢上了大学之后我的小时候玩儿了。我们在一起时候就坐不会去皮洗脑的话可以接受你的心是否还有机会赢取三星手机的日子也要注意了？我是\",\"num\":\"2\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/87513201712161814295444.jpg\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"这是结尾\",\"num\":\"4\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/25830201712161814545789.jpg\",\"num\":\"5\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/8b641201712161815089691.mp4\",\"num\":\"6\"}]}","note_like":"1","note_comment":"0","time":"2017-12-16","column_name":"爆料","note_id":"37","type_data":"note","is_like":0,"like_list":[{"uid":"40","img":"http://p0scl3b39.bkt.clouddn.com/37457201712181039081116.jpg"}],"comment_list":[],"dataType":"note"},{"id":"36","note_title":"野有蔓草--郑风","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"    这是一首恋歌，写一个露珠未干的早上，一对青年男女在田间路上不期而遇，相互倾心，欣喜之情难以抑制。\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/ff8fb201712161351033820.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"野有蔓草，零露漙兮。有美一人，清扬婉兮。邂逅相遇，适我愿兮。\\n野有蔓草，零露瀼瀼。有美一人，婉如清扬。邂逅相遇，与子偕臧。\",\"num\":\"2\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5323d201712161351598726.jpg\",\"num\":\"3\"}]}","note_like":"0","note_comment":"0","time":"2017-12-16","column_name":"周边服务","note_id":"36","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"72","name":"陈朝晖","topic_firstid":"12","topic_img":"/upload/20171216/6b814cbdcaaec7d45c75f1fbc11433d9.jpg","topic_content":"陈朝晖在周边服务发的话题","topic_time":"1513402443","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-16","topic_title":"我是周边服务的话题1","column_name":"周边服务","note_id":"72","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"41","name":"等阳荒芜了时光","comment_content":"z太阳精灵","source":"0","note_id":"35","reply_id":"40","time":"2017-12-16","reply_content":"我下了","reply_name":"等阳荒芜了时光","replyed_uid":"84","followed_is":0,"note_title":"乡愁---缅怀余光中先生","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","likeed_id":"84","dataType":"like"},{"id":"40","name":"等阳荒芜了时光","comment_content":"我下了","source":"0","note_id":"35","time":"2017-12-16","note_title":"乡愁---缅怀余光中先生","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","likeed_id":"84","followed_is":0,"dataType":"like"},{"id":"35","note_title":"乡愁---缅怀余光中先生","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"                    乡愁--缅怀余光中\\n\\n\\n\\n小时候，\\n乡愁是一枚小小的邮票，\\n我在这头，\\n母亲在那头。\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/6e159201712151818265297.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"长大后，\\n乡愁是一张窄窄的船票，\\n我在这头，\\n新娘在那头。\",\"num\":\"2\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/7915920171215181943916.jpg\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"后来啊，\\n乡愁是一方矮矮的坟墓，\\n我在外头，\\n母亲在里头。\",\"num\":\"4\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/a0582201712151820364844.jpg\",\"num\":\"5\"},{\"type\":\"text\",\"info\":\"而现在，\\n乡愁是一湾浅浅的海峡，\\n我在这头，\\n大陆在那头。\",\"num\":\"6\"}]}","note_like":"0","note_comment":"1","time":"2017-12-15","column_name":"求职招聘","note_id":"35","type_data":"note","is_like":0,"like_list":[],"comment_list":[{"id":"40","uid":"84","comment_content":"我下了","comment_time":"2017-12-16","num":"1","name":"等阳荒芜了时光","img":"http://q.qlogo.cn/qqapp/1106598454/E009DA16E590A2B5B64D960808582F13/100","level":"1","address1":"","number":"1楼","dignity":"","reply":[]},{"id":"41","uid":"84","comment_content":"z太阳精灵","comment_time":"2017-12-16","num":"2","name":"等阳荒芜了时光","img":"http://q.qlogo.cn/qqapp/1106598454/E009DA16E590A2B5B64D960808582F13/100","level":"1","address1":"","number":"2楼","dignity":"","reply":[]},{"id":"42","uid":"84","comment_content":"兔兔","comment_time":"2017-12-16","num":"3","name":"等阳荒芜了时光","img":"http://q.qlogo.cn/qqapp/1106598454/E009DA16E590A2B5B64D960808582F13/100","level":"1","address1":"","number":"3楼","dignity":"","reply":[]}],"dataType":"note"},{"id":"39","name":"陈朝晖","comment_content":"回复一楼","source":"0","note_id":"32","reply_id":"38","time":"2017-12-15","reply_content":"这是对帖子的第一条评论","reply_name":"陈朝晖","replyed_uid":"69","followed_is":0,"note_title":"陈朝晖在求职招聘中发的帖子","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","dataType":"reply"},{"id":"34","note_title":"我发的","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"1发帖了\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/66fcc201712151435452439.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"我们的确很鬼故事还是说睡觉睡觉是实话实说公司 v 是 v 是 v 是个实话实说睡觉睡觉了，我们的确是不是要把它当作一个人在一起吧嗒。我的第一时间想到的是什么意思。我的第一时间想到的是我最后的话。我们都市田园风光。我的第一时间想到的是什么意思。我们都会觉得你是不是在一起了。我的第一时间想到的是什么意思。我的第一时间想到的是什么意思。我的第一时间想到的是什么广告或者生生世世好多好多好多好多浩浩荡荡好实话实说说好多话好多\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/15581201712151436595320.mp4\",\"num\":\"3\"}]}","note_like":"1","note_comment":"1","time":"2017-12-15","column_name":"求职招聘","note_id":"34","type_data":"note","is_like":0,"like_list":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment_list":[{"id":"43","uid":"69","comment_content":"哈哈","comment_time":"2017-12-22","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[]}],"dataType":"note"},{"id":"38","name":"陈朝晖","comment_content":"这是对帖子的第一条评论","source":"0","note_id":"32","time":"2017-12-15","note_title":"陈朝晖在求职招聘中发的帖子","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"32","note_title":"陈朝晖在求职招聘中发的帖子","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"11111111\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/afcec201712141701025325.jpg\",\"num\":\"1\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5fe17201712141701096113.jpg\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/aa1a3201712141701234864.mp4\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"我222222\",\"num\":\"4\"}]}","note_like":"1","note_comment":"1","time":"2017-12-14","column_name":"求职招聘","note_id":"32","type_data":"note","is_like":0,"like_list":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment_list":[{"id":"38","uid":"69","comment_content":"这是对帖子的第一条评论","comment_time":"2017-12-15","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[]},{"id":"39","uid":"69","comment_content":"回复一楼","comment_time":"2017-12-15","num":"2","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"2楼","dignity":"楼主","reply":[]}],"dataType":"note"},{"id":"37","name":"陈朝晖","comment_content":"回复4楼","source":"1","note_id":"70","reply_id":"36","time":"2017-12-08","reply_content":"吼吼","reply_name":"洋洋","replyed_uid":"55","followed_is":0,"note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","dataType":"reply"},{"id":"35","name":"陈朝晖","comment_content":"回复二楼评论","source":"1","note_id":"70","reply_id":"34","time":"2017-12-08","reply_content":"二楼评论","reply_name":"陈朝晖","replyed_uid":"69","followed_is":0,"note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","dataType":"reply"},{"id":"34","name":"陈朝晖","comment_content":"二楼评论","source":"1","note_id":"70","time":"2017-12-08","note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","dataType":"comment"},{"id":"33","name":"陈朝晖","comment_content":"一楼评论","source":"1","note_id":"70","time":"2017-12-08","note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","dataType":"comment"},{"id":"70","name":"陈朝晖","topic_firstid":"7","topic_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","topic_time":"1512700728","topic_link":"","topic_address":"我的位置","topic_like":"1","topic_comment":"3","time":"2017-12-08","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"70","type_data":"topic","is_like":0,"like_list":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment_list":[{"id":"33","uid":"69","comment_content":"一楼评论","comment_time":"2017-12-08","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[]},{"id":"34","uid":"69","comment_content":"二楼评论","comment_time":"2017-12-08","num":"2","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"2楼","dignity":"楼主","reply":[]},{"id":"35","uid":"69","comment_content":"回复二楼评论","comment_time":"2017-12-08","num":"3","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"3楼","dignity":"楼主","reply":[]},{"id":"36","uid":"55","comment_content":"吼吼","comment_time":"2017-12-08","num":"4","name":"洋洋","img":"http://p0scl3b39.bkt.clouddn.com/headimg.png","level":"1","address1":"北京市","number":"4楼","dignity":"","reply":[]},{"id":"37","uid":"69","comment_content":"回复4楼","comment_time":"2017-12-08","num":"5","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"5楼","dignity":"楼主","reply":[]}],"dataType":"topic"}],"userInfo":{"img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","name":"陈朝晖","abstract":"陈朝晖的简介就是这么简单","sex":"男","address1":"我是住燕郊是吧","level":"1","points":"3541","like":"0","fans":"1","concern":"0","time":14,"note_num":11,"topic_num":18,"comment_num":10,"uided":0},"personal":[{"title":"房屋租售的帖子","des":"我的人家，你的时候你们","photo":"http://p0scl3b39.bkt.clouddn.com/af08a201712221614354848.jpg","link":"17319194667","phone":"17319194667"}]}
     * result : 200
     * msg : 查询成功
     */

    private DataBeanX data;
    private String result;
    private String msg;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBeanX {
        /**
         * data : [{"id":"111","name":"陈朝晖","topic_firstid":"17","topic_img":"http://p0scl3b39.bkt.clouddn.com/a5dc4201712221819503805.jpg,http://p0scl3b39.bkt.clouddn.com/a9193201712221819519875.jpg,http://p0scl3b39.bkt.clouddn.com/a0b73201712221819535718.jpg,http://p0scl3b39.bkt.clouddn.com/afd8e20171222182032990.jpg","topic_content":"求职招聘\n找个大力士","topic_time":"1513937990","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-22","topic_title":"你猜我现在在干什么","column_name":"求职招聘","note_id":"111","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"110","name":"陈朝晖","topic_firstid":"10","topic_img":"http://p0scl3b39.bkt.clouddn.com/c0170201712221812102796.jpg","topic_content":"冬至吃饺子","topic_time":"1513937530","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-22","topic_title":"我是话题测试2","column_name":"爆料","note_id":"110","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"46","name":"陈朝晖","comment_content":"太饿了","source":"0","note_id":"50","time":"2017-12-22","note_title":"冬至","note_img":"","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"45","name":"陈朝晖","comment_content":"好啊好啊","source":"0","note_id":"50","time":"2017-12-22","note_title":"冬至","note_img":"","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"44","name":"陈朝晖","comment_content":"今天要吃饺子","source":"0","note_id":"50","time":"2017-12-22","note_title":"冬至","note_img":"","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"50","note_title":"冬至","name":"陈朝晖","note_img":"","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"今天是冬至，大家要吃饺子啊\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5e56e201712221808138946.jpg\",\"num\":\"1\"}]}","note_like":"0","note_comment":"3","time":"2017-12-22","column_name":"求职招聘","note_id":"50","type_data":"note","is_like":0,"like_list":[],"comment_list":[{"id":"44","uid":"69","comment_content":"今天要吃饺子","comment_time":"2017-12-22","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[]},{"id":"45","uid":"69","comment_content":"好啊好啊","comment_time":"2017-12-22","num":"2","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"2楼","dignity":"楼主","reply":[]},{"id":"46","uid":"69","comment_content":"太饿了","comment_time":"2017-12-22","num":"3","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"3楼","dignity":"楼主","reply":[]}],"dataType":"note"},{"id":"49","note_title":"收废品","name":"陈朝晖","note_img":"","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"回收旧电器 洗衣机 烂冰箱 烂彩电 烂空调 烂电瓶回收～\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/ca4fb2017122217335574.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"回收旧电器 洗衣机 烂冰箱 烂彩电 烂空调 烂电瓶回收～回收旧电器 洗衣机 烂冰箱 烂彩电 烂空调 烂电瓶回收～\",\"num\":\"2\"}]}","note_like":"0","note_comment":"0","time":"2017-12-22","column_name":"周边服务","note_id":"49","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"43","name":"陈朝晖","comment_content":"哈哈","source":"0","note_id":"34","time":"2017-12-22","note_title":"我发的","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"33","note_title":"图解了","uid":"84","name":"等阳荒芜了时光","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"\",\"num\":\"0\"}]}","note_columnid":"21","note_time":"1513314550","note_like":"2","note_comment":"0","time":"2017-12-21","column_name":"求职招聘","note_id":"33","type_data":"note","is_like":0,"likeed_id":"84","dataType":"like"},{"id":"48","note_title":"房屋租售的帖子","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"我的人家，你的时候你们\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/e3b23201712211543011343.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"我们都市全部的生活了？你说过于执着地说、一定程度的话，我的人家的确如此，我的人家的确如此，我们都会觉得你是因为有人在一起\",\"num\":\"2\"}]}","note_like":"0","note_comment":"0","time":"2017-12-21","column_name":"房屋租售","note_id":"48","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"34","note_title":"我发的","uid":"69","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"1发帖了\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/66fcc201712151435452439.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"我们的确很鬼故事还是说睡觉睡觉是实话实说公司 v 是 v 是 v 是个实话实说睡觉睡觉了，我们的确是不是要把它当作一个人在一起吧嗒。我的第一时间想到的是什么意思。我的第一时间想到的是我最后的话。我们都市田园风光。我的第一时间想到的是什么意思。我们都会觉得你是不是在一起了。我的第一时间想到的是什么意思。我的第一时间想到的是什么意思。我的第一时间想到的是什么广告或者生生世世好多好多好多好多浩浩荡荡好实话实说说好多话好多\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/15581201712151436595320.mp4\",\"num\":\"3\"}]}","note_columnid":"21","note_time":"1513319829","note_like":"1","note_comment":"1","time":"2017-12-21","column_name":"求职招聘","note_id":"34","type_data":"note","is_like":0,"likeed_id":"69","dataType":"like"},{"id":"109","name":"陈朝晖","uid":"69","topic_firstid":"11","topic_img":"http://p0scl3b39.bkt.clouddn.com/dab7620171220182201607.jpg","topic_content":"我","topic_time":"1513765321","topic_link":"","topic_address":"我的位置","topic_like":"1","topic_comment":"0","time":"2017-12-20","topic_title":"我们都是周边服务的话题","column_name":"爆料","note_id":"109","type_data":"topic","is_like":0,"likeed_id":"69","followed_is":0,"dataType":"like"},{"id":"109","name":"陈朝晖","topic_firstid":"11","topic_img":"http://p0scl3b39.bkt.clouddn.com/dab7620171220182201607.jpg","topic_content":"我","topic_time":"1513765321","topic_link":"","topic_address":"我的位置","topic_like":"1","topic_comment":"0","time":"2017-12-20","topic_title":"我们都是周边服务的话题","column_name":"爆料","note_id":"109","type_data":"topic","is_like":0,"like_list":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment_list":[],"dataType":"topic"},{"id":"47","note_title":"我厄尔","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"法院官方发发的\",\"num\":\"0\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/4424a201712201619173388.mp4\",\"num\":\"1\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/6260c201712201619247148.mp4\",\"num\":\"2\"},{\"type\":\"text\",\"info\":\"你们是因为自己太多了。我\",\"num\":\"3\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/c768b201712201619339694.jpg\",\"num\":\"4\"},{\"type\":\"text\",\"info\":\"\",\"num\":\"0\"},{\"type\":\"text\",\"info\":\"是否会回复\",\"num\":\"1\"}]}","note_like":"0","note_comment":"0","time":"2017-12-20","column_name":"爆料","note_id":"47","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"108","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/8a2c2201712201520135504.jpg","topic_content":"我的人生","topic_time":"1513754413","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-20","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"108","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"46","note_title":"我","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"你\",\"num\":\"0\"}]}","note_like":"0","note_comment":"0","time":"2017-12-20","column_name":"爆料","note_id":"46","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"107","name":"陈朝晖","topic_firstid":"7","topic_img":"","topic_content":"我的人","topic_time":"1513754336","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-20","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"107","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"95","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/43fcf201712201026224307.jpg","topic_content":"我","topic_time":"1513736782","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-20","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"95","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"94","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/d371f20171220102434602.jpg","topic_content":"粉丝高高瘦瘦的互动对话大好河山","topic_time":"1513736674","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-20","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"94","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"45","note_title":"我的","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"你的时候就会觉得\",\"num\":\"0\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/2cdf5201712201023269402.mp4\",\"num\":\"1\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/1d3d8201712201023323756.jpg\",\"num\":\"2\"}]}","note_like":"0","note_comment":"0","time":"2017-12-20","column_name":"爆料","note_id":"45","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"93","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/3cf9920171219180048856.jpg","topic_content":"我发的话题","topic_time":"1513677648","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"93","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"92","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/7e03220171219175930806.jpg","topic_content":"我的人家的确是","topic_time":"1513677570","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"92","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"91","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/44e77201712191759003324.jpg","topic_content":"我的人生态度，你的时候你","topic_time":"1513677540","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"91","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"32","note_title":"陈朝晖在求职招聘中发的帖子","uid":"69","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"11111111\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/afcec201712141701025325.jpg\",\"num\":\"1\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5fe17201712141701096113.jpg\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/aa1a3201712141701234864.mp4\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"我222222\",\"num\":\"4\"}]}","note_columnid":"21","note_time":"1513242103","note_like":"1","note_comment":"1","time":"2017-12-19","column_name":"求职招聘","note_id":"32","type_data":"note","is_like":0,"likeed_id":"69","dataType":"like"},{"id":"70","name":"陈朝晖","uid":"69","topic_firstid":"7","topic_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","topic_time":"1512700728","topic_link":"","topic_address":"我的位置","topic_like":"1","topic_comment":"3","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"70","type_data":"topic","is_like":0,"likeed_id":"69","followed_is":0,"dataType":"like"},{"id":"38","name":"陈朝晖","comment_content":"这是对帖子的第一条评论","source":"0","note_id":"32","time":"2017-12-19","note_title":"陈朝晖在求职招聘中发的帖子","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","likeed_id":"69","followed_is":0,"dataType":"like"},{"id":"39","name":"陈朝晖","comment_content":"回复一楼","source":"0","note_id":"32","reply_id":"38","time":"2017-12-19","reply_content":"这是对帖子的第一条评论","reply_name":"陈朝晖","replyed_uid":"69","followed_is":0,"note_title":"陈朝晖在求职招聘中发的帖子","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","likeed_id":"69","dataType":"like"},{"id":"34","name":"陈朝晖","comment_content":"二楼评论","source":"1","note_id":"70","time":"2017-12-19","note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","likeed_id":"69","followed_is":0,"dataType":"like"},{"id":"90","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/c7761201712190943528962.jpg","topic_content":"我","topic_time":"1513647832","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-19","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"90","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"79","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/96318201712181535123048.jpg","topic_content":"请问巍巍峨峨","topic_time":"1513582512","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"79","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"78","name":"陈朝晖","topic_firstid":"7","topic_img":"http://p0scl3b39.bkt.clouddn.com/07388201712181534221810.jpg","topic_content":"请问巍巍峨峨","topic_time":"1513582462","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"78","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"75","name":"陈朝晖","topic_firstid":"7","topic_img":"/upload/20171218/4e36c918afafc8b9a7fbbbbb8a2851c0.jpg","topic_content":"我","topic_time":"1513580406","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"75","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"74","name":"陈朝晖","topic_firstid":"7","topic_img":"/upload/20171218/1843972def93f14557f11698aafddf70.jpg,/upload/20171218/faba7cb85c62ea61392cf3b7ad266755.jpg,/upload/20171218/ae7a4a58f2ed56fed279cd7fd758ce00.jpg,/upload/20171218/fcb542afd98d296f51cb3b3d1ec12486.jpg","topic_content":"发布帖子\n啦啦啦啦啦啦啦啦啦啦啦","topic_time":"1513580277","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"74","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"73","name":"陈朝晖","topic_firstid":"7","topic_img":"/upload/20171218/3d580ba64721b2bc5b03df0e8b822966.jpg,/upload/20171218/b5bd08a681bdf8f577c65de1b679ddd7.jpg,/upload/20171218/b85f4ea36467d8ca4b706beeb379de35.jpg,/upload/20171218/01754f8e3ed0ba2e8dc33ffea956545a.jpg","topic_content":"分享话题测试\n啦啦啦啦啦啦啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦啦","topic_time":"1513579956","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-18","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"73","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"37","note_title":"这是爆料的帖子","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"陈朝晖发的\",\"num\":\"0\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/aa13c201712161813013142.mp4\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"多写点内容是什么时候开始喜欢上了大学之后我的小时候玩儿了。我们在一起时候就坐不会去皮洗脑的话可以接受你的心是否还有机会赢取三星手机的日子也要注意了？我是多写点内容是什么时候开始喜欢上了大学之后我的小时候玩儿了。我们在一起时候就坐不会去皮洗脑的话可以接受你的心是否还有机会赢取三星手机的日子也要注意了？我是多写点内容是什么时候开始喜欢上了大学之后我的小时候玩儿了。我们在一起时候就坐不会去皮洗脑的话可以接受你的心是否还有机会赢取三星手机的日子也要注意了？我是\\n多写点内容是什么时候开始喜欢上了大学之后我的小时候玩儿了。我们在一起时候就坐不会去皮洗脑的话可以接受你的心是否还有机会赢取三星手机的日子也要注意了？我是\",\"num\":\"2\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/87513201712161814295444.jpg\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"这是结尾\",\"num\":\"4\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/25830201712161814545789.jpg\",\"num\":\"5\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/8b641201712161815089691.mp4\",\"num\":\"6\"}]}","note_like":"1","note_comment":"0","time":"2017-12-16","column_name":"爆料","note_id":"37","type_data":"note","is_like":0,"like_list":[{"uid":"40","img":"http://p0scl3b39.bkt.clouddn.com/37457201712181039081116.jpg"}],"comment_list":[],"dataType":"note"},{"id":"36","note_title":"野有蔓草--郑风","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"    这是一首恋歌，写一个露珠未干的早上，一对青年男女在田间路上不期而遇，相互倾心，欣喜之情难以抑制。\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/ff8fb201712161351033820.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"野有蔓草，零露漙兮。有美一人，清扬婉兮。邂逅相遇，适我愿兮。\\n野有蔓草，零露瀼瀼。有美一人，婉如清扬。邂逅相遇，与子偕臧。\",\"num\":\"2\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5323d201712161351598726.jpg\",\"num\":\"3\"}]}","note_like":"0","note_comment":"0","time":"2017-12-16","column_name":"周边服务","note_id":"36","type_data":"note","is_like":0,"like_list":[],"comment_list":[],"dataType":"note"},{"id":"72","name":"陈朝晖","topic_firstid":"12","topic_img":"/upload/20171216/6b814cbdcaaec7d45c75f1fbc11433d9.jpg","topic_content":"陈朝晖在周边服务发的话题","topic_time":"1513402443","topic_link":"","topic_address":"我的位置","topic_like":"0","topic_comment":"0","time":"2017-12-16","topic_title":"我是周边服务的话题1","column_name":"周边服务","note_id":"72","type_data":"topic","is_like":0,"like_list":[],"comment_list":[],"dataType":"topic"},{"id":"41","name":"等阳荒芜了时光","comment_content":"z太阳精灵","source":"0","note_id":"35","reply_id":"40","time":"2017-12-16","reply_content":"我下了","reply_name":"等阳荒芜了时光","replyed_uid":"84","followed_is":0,"note_title":"乡愁---缅怀余光中先生","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","likeed_id":"84","dataType":"like"},{"id":"40","name":"等阳荒芜了时光","comment_content":"我下了","source":"0","note_id":"35","time":"2017-12-16","note_title":"乡愁---缅怀余光中先生","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","likeed_id":"84","followed_is":0,"dataType":"like"},{"id":"35","note_title":"乡愁---缅怀余光中先生","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"                    乡愁--缅怀余光中\\n\\n\\n\\n小时候，\\n乡愁是一枚小小的邮票，\\n我在这头，\\n母亲在那头。\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/6e159201712151818265297.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"长大后，\\n乡愁是一张窄窄的船票，\\n我在这头，\\n新娘在那头。\",\"num\":\"2\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/7915920171215181943916.jpg\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"后来啊，\\n乡愁是一方矮矮的坟墓，\\n我在外头，\\n母亲在里头。\",\"num\":\"4\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/a0582201712151820364844.jpg\",\"num\":\"5\"},{\"type\":\"text\",\"info\":\"而现在，\\n乡愁是一湾浅浅的海峡，\\n我在这头，\\n大陆在那头。\",\"num\":\"6\"}]}","note_like":"0","note_comment":"1","time":"2017-12-15","column_name":"求职招聘","note_id":"35","type_data":"note","is_like":0,"like_list":[],"comment_list":[{"id":"40","uid":"84","comment_content":"我下了","comment_time":"2017-12-16","num":"1","name":"等阳荒芜了时光","img":"http://q.qlogo.cn/qqapp/1106598454/E009DA16E590A2B5B64D960808582F13/100","level":"1","address1":"","number":"1楼","dignity":"","reply":[]},{"id":"41","uid":"84","comment_content":"z太阳精灵","comment_time":"2017-12-16","num":"2","name":"等阳荒芜了时光","img":"http://q.qlogo.cn/qqapp/1106598454/E009DA16E590A2B5B64D960808582F13/100","level":"1","address1":"","number":"2楼","dignity":"","reply":[]},{"id":"42","uid":"84","comment_content":"兔兔","comment_time":"2017-12-16","num":"3","name":"等阳荒芜了时光","img":"http://q.qlogo.cn/qqapp/1106598454/E009DA16E590A2B5B64D960808582F13/100","level":"1","address1":"","number":"3楼","dignity":"","reply":[]}],"dataType":"note"},{"id":"39","name":"陈朝晖","comment_content":"回复一楼","source":"0","note_id":"32","reply_id":"38","time":"2017-12-15","reply_content":"这是对帖子的第一条评论","reply_name":"陈朝晖","replyed_uid":"69","followed_is":0,"note_title":"陈朝晖在求职招聘中发的帖子","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","dataType":"reply"},{"id":"34","note_title":"我发的","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"1发帖了\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/66fcc201712151435452439.jpg\",\"num\":\"1\"},{\"type\":\"text\",\"info\":\"我们的确很鬼故事还是说睡觉睡觉是实话实说公司 v 是 v 是 v 是个实话实说睡觉睡觉了，我们的确是不是要把它当作一个人在一起吧嗒。我的第一时间想到的是什么意思。我的第一时间想到的是我最后的话。我们都市田园风光。我的第一时间想到的是什么意思。我们都会觉得你是不是在一起了。我的第一时间想到的是什么意思。我的第一时间想到的是什么意思。我的第一时间想到的是什么广告或者生生世世好多好多好多好多浩浩荡荡好实话实说说好多话好多\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/15581201712151436595320.mp4\",\"num\":\"3\"}]}","note_like":"1","note_comment":"1","time":"2017-12-15","column_name":"求职招聘","note_id":"34","type_data":"note","is_like":0,"like_list":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment_list":[{"id":"43","uid":"69","comment_content":"哈哈","comment_time":"2017-12-22","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[]}],"dataType":"note"},{"id":"38","name":"陈朝晖","comment_content":"这是对帖子的第一条评论","source":"0","note_id":"32","time":"2017-12-15","note_title":"陈朝晖在求职招聘中发的帖子","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","type_data":"note","column_name":"求职招聘","dataType":"comment"},{"id":"32","note_title":"陈朝晖在求职招聘中发的帖子","name":"陈朝晖","note_img":"http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg","note_content":"{\"data\":[{\"type\":\"text\",\"info\":\"11111111\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/afcec201712141701025325.jpg\",\"num\":\"1\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5fe17201712141701096113.jpg\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/aa1a3201712141701234864.mp4\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"我222222\",\"num\":\"4\"}]}","note_like":"1","note_comment":"1","time":"2017-12-14","column_name":"求职招聘","note_id":"32","type_data":"note","is_like":0,"like_list":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment_list":[{"id":"38","uid":"69","comment_content":"这是对帖子的第一条评论","comment_time":"2017-12-15","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[]},{"id":"39","uid":"69","comment_content":"回复一楼","comment_time":"2017-12-15","num":"2","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"2楼","dignity":"楼主","reply":[]}],"dataType":"note"},{"id":"37","name":"陈朝晖","comment_content":"回复4楼","source":"1","note_id":"70","reply_id":"36","time":"2017-12-08","reply_content":"吼吼","reply_name":"洋洋","replyed_uid":"55","followed_is":0,"note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","dataType":"reply"},{"id":"35","name":"陈朝晖","comment_content":"回复二楼评论","source":"1","note_id":"70","reply_id":"34","time":"2017-12-08","reply_content":"二楼评论","reply_name":"陈朝晖","replyed_uid":"69","followed_is":0,"note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","dataType":"reply"},{"id":"34","name":"陈朝晖","comment_content":"二楼评论","source":"1","note_id":"70","time":"2017-12-08","note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","dataType":"comment"},{"id":"33","name":"陈朝晖","comment_content":"一楼评论","source":"1","note_id":"70","time":"2017-12-08","note_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","type_data":"topic","topic_title":"周边服务的第一个话题","column_name":"爆料","dataType":"comment"},{"id":"70","name":"陈朝晖","topic_firstid":"7","topic_img":"/upload/20171215/04ed26048f8696b7c8fe1c688e29b42a.jpg","topic_content":"陈朝晖发的","topic_time":"1512700728","topic_link":"","topic_address":"我的位置","topic_like":"1","topic_comment":"3","time":"2017-12-08","topic_title":"周边服务的第一个话题","column_name":"爆料","note_id":"70","type_data":"topic","is_like":0,"like_list":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment_list":[{"id":"33","uid":"69","comment_content":"一楼评论","comment_time":"2017-12-08","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[]},{"id":"34","uid":"69","comment_content":"二楼评论","comment_time":"2017-12-08","num":"2","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"2楼","dignity":"楼主","reply":[]},{"id":"35","uid":"69","comment_content":"回复二楼评论","comment_time":"2017-12-08","num":"3","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"3楼","dignity":"楼主","reply":[]},{"id":"36","uid":"55","comment_content":"吼吼","comment_time":"2017-12-08","num":"4","name":"洋洋","img":"http://p0scl3b39.bkt.clouddn.com/headimg.png","level":"1","address1":"北京市","number":"4楼","dignity":"","reply":[]},{"id":"37","uid":"69","comment_content":"回复4楼","comment_time":"2017-12-08","num":"5","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"5楼","dignity":"楼主","reply":[]}],"dataType":"topic"}]
         * userInfo : {"img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","name":"陈朝晖","abstract":"陈朝晖的简介就是这么简单","sex":"男","address1":"我是住燕郊是吧","level":"1","points":"3541","like":"0","fans":"1","concern":"0","time":14,"note_num":11,"topic_num":18,"comment_num":10,"uided":0}
         * personal : [{"title":"房屋租售的帖子","des":"我的人家，你的时候你们","photo":"http://p0scl3b39.bkt.clouddn.com/af08a201712221614354848.jpg","link":"17319194667","phone":"17319194667"}]
         */

        private UserInfoBean userInfo;
        private List<DataBean> data;
        private List<PersonalBean> personal;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public List<PersonalBean> getPersonal() {
            return personal;
        }

        public void setPersonal(List<PersonalBean> personal) {
            this.personal = personal;
        }

        public static class UserInfoBean {
            /**
             * img : http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg
             * name : 陈朝晖
             * abstract : 陈朝晖的简介就是这么简单
             * sex : 男
             * address1 : 我是住燕郊是吧
             * level : 1
             * points : 3541
             * like : 0
             * fans : 1
             * concern : 0
             * time : 14
             * note_num : 11
             * topic_num : 18
             * comment_num : 10
             * uided : 0
             */

            private String img;
            private String name;
            @SerializedName("abstract")
            private String abstractX;
            private String sex;
            private String address1;
            private String level;
            private String points;
            private String like;
            private String fans;
            private String concern;
            private int time;
            private int note_num;
            private int topic_num;
            private int comment_num;
            private int uided;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAbstractX() {
                return abstractX;
            }

            public void setAbstractX(String abstractX) {
                this.abstractX = abstractX;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }

            public String getLike() {
                return like;
            }

            public void setLike(String like) {
                this.like = like;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public String getConcern() {
                return concern;
            }

            public void setConcern(String concern) {
                this.concern = concern;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getNote_num() {
                return note_num;
            }

            public void setNote_num(int note_num) {
                this.note_num = note_num;
            }

            public int getTopic_num() {
                return topic_num;
            }

            public void setTopic_num(int topic_num) {
                this.topic_num = topic_num;
            }

            public int getComment_num() {
                return comment_num;
            }

            public void setComment_num(int comment_num) {
                this.comment_num = comment_num;
            }

            public int getUided() {
                return uided;
            }

            public void setUided(int uided) {
                this.uided = uided;
            }
        }

        public static class DataBean {
            /**
             * id : 111
             * name : 陈朝晖
             * topic_firstid : 17
             * topic_img : http://p0scl3b39.bkt.clouddn.com/a5dc4201712221819503805.jpg,http://p0scl3b39.bkt.clouddn.com/a9193201712221819519875.jpg,http://p0scl3b39.bkt.clouddn.com/a0b73201712221819535718.jpg,http://p0scl3b39.bkt.clouddn.com/afd8e20171222182032990.jpg
             * topic_content : 求职招聘
             找个大力士
             * topic_time : 1513937990
             * topic_link :
             * topic_address : 我的位置
             * topic_like : 0
             * topic_comment : 0
             * time : 2017-12-22
             * topic_title : 你猜我现在在干什么
             * column_name : 求职招聘
             * note_id : 111
             * type_data : topic
             * is_like : 0
             * like_list : []
             * comment_list : []
             * dataType : topic
             * comment_content : 太饿了
             * source : 0
             * note_title : 冬至
             * note_img :
             * note_content : {"data":[{"type":"text","info":"今天是冬至，大家要吃饺子啊","num":"0"},{"type":"img","info":"http:\/\/p0scl3b39.bkt.clouddn.com\/images\/5e56e201712221808138946.jpg","num":"1"}]}
             * note_like : 0
             * note_comment : 3
             * uid : 84
             * note_columnid : 21
             * note_time : 1513314550
             * likeed_id : 84
             * followed_is : 0
             * reply_id : 38
             * reply_content : 这是对帖子的第一条评论
             * reply_name : 陈朝晖
             * replyed_uid : 69
             */

            private String id;
            private String name;
            private String topic_firstid;
            private String topic_img;
            private String topic_content;
            private String topic_time;
            private String topic_link;
            private String topic_address;
            private String topic_like;
            private String topic_comment;
            private String time;
            private String topic_title;
            private String column_name;
            private String note_id;
            private String type_data;
            private int is_like;
            private String dataType;
            private String comment_content;
            private String source;
            private String note_title;
            private String note_img;
            private String note_content;
            private String note_like;
            private String note_comment;
            private String uid;
            private String note_columnid;
            private String note_time;
            private String likeed_id;
            private int followed_is;
            private String reply_id;
            private String reply_content;
            private String reply_name;
            private String replyed_uid;
            private List<?> like_list;
            private List<?> comment_list;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTopic_firstid() {
                return topic_firstid;
            }

            public void setTopic_firstid(String topic_firstid) {
                this.topic_firstid = topic_firstid;
            }

            public String getTopic_img() {
                return topic_img;
            }

            public void setTopic_img(String topic_img) {
                this.topic_img = topic_img;
            }

            public String getTopic_content() {
                return topic_content;
            }

            public void setTopic_content(String topic_content) {
                this.topic_content = topic_content;
            }

            public String getTopic_time() {
                return topic_time;
            }

            public void setTopic_time(String topic_time) {
                this.topic_time = topic_time;
            }

            public String getTopic_link() {
                return topic_link;
            }

            public void setTopic_link(String topic_link) {
                this.topic_link = topic_link;
            }

            public String getTopic_address() {
                return topic_address;
            }

            public void setTopic_address(String topic_address) {
                this.topic_address = topic_address;
            }

            public String getTopic_like() {
                return topic_like;
            }

            public void setTopic_like(String topic_like) {
                this.topic_like = topic_like;
            }

            public String getTopic_comment() {
                return topic_comment;
            }

            public void setTopic_comment(String topic_comment) {
                this.topic_comment = topic_comment;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTopic_title() {
                return topic_title;
            }

            public void setTopic_title(String topic_title) {
                this.topic_title = topic_title;
            }

            public String getColumn_name() {
                return column_name;
            }

            public void setColumn_name(String column_name) {
                this.column_name = column_name;
            }

            public String getNote_id() {
                return note_id;
            }

            public void setNote_id(String note_id) {
                this.note_id = note_id;
            }

            public String getType_data() {
                return type_data;
            }

            public void setType_data(String type_data) {
                this.type_data = type_data;
            }

            public int getIs_like() {
                return is_like;
            }

            public void setIs_like(int is_like) {
                this.is_like = is_like;
            }

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public String getComment_content() {
                return comment_content;
            }

            public void setComment_content(String comment_content) {
                this.comment_content = comment_content;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getNote_title() {
                return note_title;
            }

            public void setNote_title(String note_title) {
                this.note_title = note_title;
            }

            public String getNote_img() {
                return note_img;
            }

            public void setNote_img(String note_img) {
                this.note_img = note_img;
            }

            public String getNote_content() {
                return note_content;
            }

            public void setNote_content(String note_content) {
                this.note_content = note_content;
            }

            public String getNote_like() {
                return note_like;
            }

            public void setNote_like(String note_like) {
                this.note_like = note_like;
            }

            public String getNote_comment() {
                return note_comment;
            }

            public void setNote_comment(String note_comment) {
                this.note_comment = note_comment;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getNote_columnid() {
                return note_columnid;
            }

            public void setNote_columnid(String note_columnid) {
                this.note_columnid = note_columnid;
            }

            public String getNote_time() {
                return note_time;
            }

            public void setNote_time(String note_time) {
                this.note_time = note_time;
            }

            public String getLikeed_id() {
                return likeed_id;
            }

            public void setLikeed_id(String likeed_id) {
                this.likeed_id = likeed_id;
            }

            public int getFollowed_is() {
                return followed_is;
            }

            public void setFollowed_is(int followed_is) {
                this.followed_is = followed_is;
            }

            public String getReply_id() {
                return reply_id;
            }

            public void setReply_id(String reply_id) {
                this.reply_id = reply_id;
            }

            public String getReply_content() {
                return reply_content;
            }

            public void setReply_content(String reply_content) {
                this.reply_content = reply_content;
            }

            public String getReply_name() {
                return reply_name;
            }

            public void setReply_name(String reply_name) {
                this.reply_name = reply_name;
            }

            public String getReplyed_uid() {
                return replyed_uid;
            }

            public void setReplyed_uid(String replyed_uid) {
                this.replyed_uid = replyed_uid;
            }

            public List<?> getLike_list() {
                return like_list;
            }

            public void setLike_list(List<?> like_list) {
                this.like_list = like_list;
            }

            public List<?> getComment_list() {
                return comment_list;
            }

            public void setComment_list(List<?> comment_list) {
                this.comment_list = comment_list;
            }
        }

        public static class PersonalBean {
            /**
             * title : 房屋租售的帖子
             * des : 我的人家，你的时候你们
             * photo : http://p0scl3b39.bkt.clouddn.com/af08a201712221614354848.jpg
             * link : 17319194667
             * phone : 17319194667
             */

            private String title;
            private String des;
            private String photo;
            private String link;
            private String phone;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }
}



