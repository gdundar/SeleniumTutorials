$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/yasinbekar/IdeaProjects/SeleniumTutorials/src/test/java/API_Murodil/cucumberApi/features/EmployeeRestAPI.feature");
formatter.feature({
  "name": "",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Post an Employee method test",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ApiPost"
    }
  ]
});
formatter.step({
  "name": "Content ype and Accept type is Json",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I post a new Employee with \"random\" id",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Status code is 201",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Response Json should contain Employee info",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I send a Get request with \"random\" id",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Status code is 200",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Employee JSON Response Data should match the posted JSON data",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});