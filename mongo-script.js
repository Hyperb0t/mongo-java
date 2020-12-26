
db.person.insertOne(
    {
        name: "Вася Пупкин",
        age: 25,
        skills: ["менеджмент", "аналитика"],
        phone: "+79876543210"
    }
);

db.person.insertOne(
    {
        name: "Екатерина Олегова",
        age: 26,
        skills: ["frontend", "typescript", "react"],
        phone: "+79878754321",
        previousJobs: ["simbirsoft"],
        experience: 2,
        email: "ekolegonv@gmail.com"
    }
);

db.person.insertOne(
    {
        name: "Евгений Гениусов",
        age: 23,
        skills: ["java", "spring", "sql", "rabbitmq"],
        phone: "+79878759921",
        projects: ["сложный бэкенд"],
        email: "evgenius@gmail.com",
        linkedIn: "linkedin.com/evgenius"
    }
);

db.person.find({skills: "java"});

db.person.find( { $or: [ {skills: "java"}, {skills: "react"} ] } );

db.person.find( { $or: [ {skills: "java"}, {age: {$gt: 24} } ] } );

db.person.find({ _id: ObjectId("5fe6f44f61b53600baeb4841") });

db.person.find({experience: {$exists: true} });

db.person.find({experience: {$exists: true}}, {name: 1, _id: 0} );

db.person.find( { $or: [ {skills: "java"}, {age: {$gt: 24} } ] } ).sort({age: 1, name: 1});

db.person.updateOne( {name: "Вася Пупкин"}, { $set: {email: "vpupkin@gmail.com"} } );

db.person.updateOne( {name: "Екатерина Олегова"}, { $inc: {experience: 1 } });

db.person.updateOne( {name: "Евгений Гениусов"}, { $push: {skills: "mongodb"}});

db.company.insertOne( {name: "Yandex", industry: "IT"});

db.company.insertOne( {name: "ПромОргТорг", industry: "fuel"});

db.person.updateOne( {_id: ObjectId("5fe6f75161b53600baeb4844")}, { $push: {previousJobs: ObjectId("5fe715fc61b53600baeb4849")}});

db.vacancy.insertOne(
    {
        title: "Погромист",
        skills: ["php"],
        company: ObjectId("5fe7178361b53600baeb484c"),
        salary: 30000
    }
);

db.person.find( {email: {$exists: true}, $or: [ {skills: "java"}, {age: {$gt: 24} } ] } );
