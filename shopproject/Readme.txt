Instructions to Test the program

1) Open any client (Restclient,postman etc) which are used to test rest webservices

URL : http://localhost:8080/shop/details
HttpMethod : PUT
Content-type : application/json
Body : 

{
  "name": "LIC of India",
  "addressDto": [
    {
      "number": "Chinchwad Br 95B,II Floor, Gheewala Complex,Opp. Ramkrishna More Sabhagruha,Chinchwad, Pune",
      "postcode": "411033"
    }
  ]
}

Note : number is address of any shop


URL : http://localhost:8080/customer/18.6187304/73.7536695/
HttpMethod : GET
