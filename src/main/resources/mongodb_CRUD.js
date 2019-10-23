// 插入
db.message_box.insertOne({company_id:1391,user_id:4998,message_id:999,is_readed:0,created_date:'2019-08-26T12:07:42',msg_type:'BIND',alert_id:3});
// 更新
db.message_box.updateOne({msg_type:'BIND'},{$set:{company_id:NumberLong(1391),user_id:NumberLong(4998),message_id:NumberLong(999),is_readed:NumberLong(0),alert_id:NumberLong(3)}});
// 删除
db.message_box.deleteOne({message_id:999});
// 查询，>=
db.message_box.find({message_id:{$gte:720}});
// -1降序,1升序
db.message_box.find({msg_type:{$type:'string'}}).sort({created_date:-1}).skip(20).limit(3);
// 分组 1包含,0不包含,$last获取资源文档排序的最后一个文档数据
db.message_box.aggregate([{$match:{is_readed:1}},{$group:{_id:'$msg_type',msgNum:{$sum:NumberLong(1)},createdDate:{$last:'$created_date'}}},{$project:{msgType:'$_id',_id:0,msgNum:1,createdDate:1}}]);
// 多表关联查询
db.message.aggregate([{$match:{alert_id:2}},{$lookup:{from:'message_box',localField:'_id',foreignField:'message_id',as:'mb'}},{$match:{'mb.is_readed':0}},{$project:{_id:0,alert_id:1,mb:1}}]);

