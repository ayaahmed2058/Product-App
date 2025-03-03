# Products App - MVP

📌 Overview
This application retrieves a list of products from the [DummyJSON API](https://dummyjson.com/products) and displays them in a list. Users can add products to their favorites and remove them when needed.

🎯 Features
- Fetch products from a remote API using **Retrofit**.
- Display all products in a list.
- Allow users to **add products to favorites**.
- Show a separate list for **favorite products**.
- Enable users to **remove products from favorites**.
- Implement **MVP architecture** for separation of concerns.
- Use **Room database** for local data storage.
- Observe data changes with **LiveData**.


## 🛠 Technologies Used
- **Language**: Java
- **Architecture**: Model-View-Presenter (MVP)
- **Network Library**: Retrofit
- **Database**: Room
- **Live Data Handling**: LiveData

📌 API Endpoint
- Base URL: `https://dummyjson.com/products`
- Fetch Products: `GET /products`
