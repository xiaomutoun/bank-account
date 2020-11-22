A simple bank account system

1/ save money API:

A POST API, at the endpoint http://localhost:8080/operate, with a json request body like:

{
  "accountId": "101",
  "type": "save",
  "amount": 200
}

2/ retrieve money API:

A POST API, at the endpoint http://localhost:8080/operate, with a json request body like:

{
  "accountId": "101",
  "type": "retrieve",
  "amount": 50
}

3/ show history API:

A GET API, at the endpoint http://localhost:8080/history/{id}, where id is the client account number.


Example API call:

1/ call http://localhost:8080/operate, with POST method and request body:

{
  "accountId": "101",
  "type": "save",
  "amount": 500
}

Response: 200 OK.

2/ call http://localhost:8080/operate, with POST method and request body:

{
  "accountId": "101",
  "type": "retrieve",
  "amount": 300
}

Response: 200 OK.

3/ call http://localhost:8080/history/101, with GET method.

Response:

[
  {
    "id": 100,
    "accountId": 101,
    "type": "save",
    "amount": 500,
    "balance": 500,
    "date": "2020-11-22T21:59:57.558+00:00"
  },
  {
    "id": 101,
    "accountId": 101,
    "type": "retrieve",
    "amount": 300,
    "balance": 200,
    "date": "2020-11-22T22:01:03.890+00:00"
  }
]