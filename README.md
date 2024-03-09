# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/#build-image)
* [Coroutines section of the Spring Framework Documentation](https://docs.spring.io/spring/docs/6.1.4/spring-framework-reference/languages.html#coroutines)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#using.devtools)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#actuator)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web.reactive)
* [Prometheus](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#actuator.metrics.export.prometheus)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

## Hungry Click Client App (Customer-Facing)

### Features

- **Registration/Login**: Smooth user onboarding processes. Consider social login integrations (Facebook, Google).
- **Restaurant Discovery**: Search, filter, browse restaurants based on location, cuisine, offers, etc.
- **Detailed Menus**: Clear display of items, prices, dietary information (allergens, vegetarian, etc.), and enticing images.
- **Order Placement and Customization**: Easy-to-use interface for adding items, specifying quantities, and including special instructions.
- **Payment Gateway**: Secure integration with multiple payment options (credit/debit cards, popular digital wallets).
- **Real-time Order Tracking**: Map view with delivery partner's location, estimated delivery time.
- **Order History**: Ability to view past orders and easily re-order.
- **Ratings & Reviews**: For restaurants and delivery partners.
- **In-app Chat/Support**: For customer assistance.

### Architecture Considerations

- **Client-side**: A mobile app (likely native for iOS and Android) or a progressive web app (PWA) for broader accessibility.
- **Server-side**: A robust backend to manage user data, restaurant information, orders, and real-time communication.

### Technologies

- **Mobile Development**: Swift/Objective-C (iOS), Kotlin/Java (Android), React Native or Flutter (Cross-platform).
- **Backend**: Java (Spring).
- **Database**: PostgreSQL, MySQL, MongoDB (for flexibility).
- **Real-time Updates**: WebSockets, Firebase, Pusher.
- **Mapping/Location**: Google Maps API, Mapbox

## Food Admin App (Restaurant Owner Facing)

### Features

- **Restaurant Profile Management**: Adding/editing basic restaurant details, hours of operation, logos/images.
- **Menu Management**: Creating and updating menus, food items, detailed descriptions, pricing, and image uploads.
- **Order Management**: Accepting/rejecting incoming orders, viewing order details, marking orders as ready.
- **Live Order Tracking**: Visual view of orders and their progress (in preparation, out for delivery).
- **Analytics & Reports**: Sales data, customer insights, popular dishes to help optimize menus and promotions.
- **Customer Communication (Optional)**: In-app messaging for addressing order questions or issues.

### Architecture Considerations

- **Web-based**: Primary administration will likely be on a web app.
- **Backend connection**: Shares a common backend infrastructure with the customer app for data management.

### Technologies

- **Frontend**: React, Angular, Vue.js.
- **Backend**: Same as Client app recommendations.
- **Database**: Same as Client app recommendations.

## Delivery Partner App

### Features

- **Registration/Login**: Profile creation including vehicle and license information.
- **Order Availability**: List of available orders in the vicinity, with restaurant and customer location details.
- **Order Acceptance**: Ability to accept or decline orders.
- **Navigation**: In-app map integration for optimal routing to pickup and drop-off locations.
- **Order Status Updates**: Mark order as "picked up", "delivered".
- **Earnings Tracking**: Records of completed deliveries and earnings.
- **In-app Communication (Optional)**: Ability to contact customers or support if needed.

### Architecture Considerations

- **Mobile focus**: Native app built for Android and iOS.
- **Location-intensive**: Relies heavily on location services.

### Technologies

- **Mobile development**: Same technologies as the client app.
- **Backend**: Shares backend infrastructure for order assignment and communication.
- **Mapping/Location**: Google Maps API, Mapbox (heavily used)
