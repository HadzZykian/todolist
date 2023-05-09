

//Global variable - to store the image object
let storeImage = ""

//When user clicks on 'Save Item',
//1)store all the inputs into variables
//2)do validation
//3)calls a function from the productController.js to access the API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {


   // Prevent default action of the Form submission
   event.preventDefault();
   // 1) Select the inputs
   const title = document.querySelector('#newTitleInput').value;
   const description = document.querySelector('#newDescription').value;

   //Browser security will not be able to track/store the actual path of where you choose your image
   // e.g.    C:\Users\Desktop\t-shirt_new.jpg
   // becomes C:\fakepath\t-shirt_new.jpg
//   console.log(document.querySelector('#newItemImageFile').value + '\n' + '\t'); //'\t' = tag
   const date = document.querySelector('#newDate').value;



   /* 2)
       Do the Validation code here
   */

   // 3) calls a function from the productController.js to access the API to add items to the database
   addProduct(title, description, date); //arguments


});


// select file input
const input = document.querySelector('#newDate');
// add event listener
input.addEventListener('change', () => {
   storeImage = input.files[0]; //input.files[0] refers to the file that is upload //array of files for us to access
});
