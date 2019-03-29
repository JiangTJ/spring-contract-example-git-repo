package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method 'GET'
    urlPath('/groovy') {
      queryParameters {
        parameter "name": value(consumer(regex(nonEmpty())), producer("从入门到弃坑"))
      }
    }
  }
  response {
    status OK()
    body([
            "name": fromRequest().query("name"),
            "price": 1000
    ])
    headers {
      contentType('application/json;charset=UTF-8')
    }
  }
}
