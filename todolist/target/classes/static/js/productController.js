const addAPI= 'http://localhost:8080/item/add';
const displayAPI = 'http://127.0.0.1:8080/item/all';

//production APIs
//const addAPI = 'https://ffsdwebdemohaziq.azurewebsites.net/item/add';
//const displayAPI = 'https://fsdwebdemohaziq.azurewebsites.net/item/all';

let productController = [];

function displayItem()
{
       //fetch data from database using the REST API endpoint from Spring Boot
       fetch(displayAPI)
           .then((resp) => resp.json())
           .then(function(data) {
               console.log("2. receive data")
               console.log(data);

               data.forEach(function (item, index) {
                   const itemObj = {
                       id: item.id,
                       title: item.title,
                       description: item.description,
                       date: item.date
                  };

                  //This array consist of 12 objects
                   productController.push(itemObj);
             });

             //Display all the 12 objects from the productController array
             renderProductPage();
           })
           .catch(function(error) {
               console.log(error);
           });
}



//(3)  Display all products when user launch the product.html page
function renderProductPage() {

    let display = "";


    document.querySelector("#row").innerHTML= display;

}

function addProduct(title, description, date)
{
   const formData = new FormData();
   formData.append('title', title);
   formData.append('description', description);
   formData.append('date', date);


  fetch(addAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status
            if (response.ok) {
                alert("Successfully Added TODO!")
            }
            else {
               alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding item to Product")
        });
}
