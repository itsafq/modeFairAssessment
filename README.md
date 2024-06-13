# modeFairAssessment
Currency Conversion Automation - Selenium and JMeter - https://www.xe.com/currencyconverter/
Test Case Scenarios - [HomeAssessment-modeFair.docx](https://github.com/user-attachments/files/15823361/HomeAssessment-modeFair.docx)

# JMeter Explanation
![Desktop Screenshot 2024 06 13 - 23 15 38 50](https://github.com/itsafq/modeFairAssessment/assets/85685386/58f168c6-16e1-44c8-8828-4bb99a9f2624)
- Create a test plan
- Right click > Add > Thread(Users) > Thread Group

![Desktop Screenshot 2024 06 13 - 23 15 45 25](https://github.com/itsafq/modeFairAssessment/assets/85685386/e3be53ce-af90-4f64-b742-bf7b896c7a73)
- Configure Thread Group:
- Number of Threads (Users): Specify how many virtual users will simulate concurrent users.
- Ramp-up Period: Time in seconds over which the threads will start. For example, if 10 seconds, and 50 threads, JMeter will start 5 threads per second.
- Loop count: Number of times to execute the test. Set to a high number for load testing.

![Desktop Screenshot 2024 06 13 - 23 15 53 33](https://github.com/itsafq/modeFairAssessment/assets/85685386/95ce3a6f-6018-4dbf-bb0c-9e287009c3c9)
- Right click Thread Group > Add > Sanmpler > HTTP Request
- Configure HTTP Request:
- Protocol: 'https'
- Server name or IP: 'www.xe.com'
- Path: '\currencyconverter\

![Desktop Screenshot 2024 06 13 - 23 30 22 34](https://github.com/itsafq/modeFairAssessment/assets/85685386/33e07e35-ec18-4ba5-8b5b-dbfc652aa8e7)
- Add the required parameters:
- 'sourceCurrency': 'USD'
- 'targetCurrency': 'EUR'
- 'amount-input': 100

![Desktop Screenshot 2024 06 13 - 23 16 18 34](https://github.com/itsafq/modeFairAssessment/assets/85685386/2d15b598-6aec-4033-bdf9-286af3d4b512)
- Right click Thread Group > Add > Listener > View Results Tree
- Save Test Plan.
- Click the green play button to start the test.
- Monitor the test execution and observe the results in the View Results Tree Listener.

# Analyse Results
![Desktop Screenshot 2024 06 13 - 23 33 45 82](https://github.com/itsafq/modeFairAssessment/assets/85685386/f29fbc1e-5ab7-4161-9dba-a56d23c29c21)
- It will show details of each request/response, including times and errors.
- Check average response times
- Look for spikes in response time or errors
- Adjust the load (number of users, ramp-up period) and rerun tests as necessary to find optimal performance
