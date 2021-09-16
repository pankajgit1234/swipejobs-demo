# swipejobs-demo


JDK version: 1.8

project build command: mvn clean install

Retrieve suitable jobs for a worker based on userid 
url http://localhost:8080/api/v1/jobs/worker/{workerId}
example url :- http://localhost:8080/api/v1/jobs/worker/0

sample response:
[
{
	"jobId": 0,
	"company": "Frenex",
	"jobTitle": "The Resinator",
	"jobDescription": "Enim excepteur ex dolore commodo incididunt. Mollit officia laborum sunt nostrud id duis non. Minim consectetur enim in dolore ipsum nulla. Occaecat irure voluptate esse ut do est nostrud esse fugiat."
}, {
	"jobId": 26,
	"company": "Zytrac",
	"jobTitle": "Ambassador of buzz",
	"jobDescription": "Eiusmod velit ad et aliquip sint incididunt non excepteur ut consequat ullamco occaecat. Excepteur ullamco tempor ut est. Labore do voluptate dolore elit. Ea dolor voluptate cupidatat cupidatat non ad cillum pariatur in. Id aliqua laborum ut voluptate laboris elit. Commodo mollit proident proident voluptate. Tempor consectetur minim reprehenderit aute ea quis tempor minim adipisicing proident exercitation magna tempor."
}, {
	"jobId": 35,
	"company": "Multron",
	"jobTitle": "Sous chef",
	"jobDescription": "Sit consectetur sunt labore exercitation minim aliqua tempor fugiat tempor sint eu non consequat in. Aliquip dolore id exercitation nostrud aliquip magna eu amet ea esse fugiat. Tempor anim aute est nulla ea laboris ut cupidatat. Excepteur in commodo minim esse reprehenderit elit dolor elit cillum labore adipisicing Lorem. Aliquip commodo labore dolore ullamco cupidatat id excepteur aliquip."
}
]
