(ns smashing-clojure.generic-service-test
  (:require [clojure.test :refer :all]
            [smashing-clojure.generic-service :as service]))

(defn set-applier [langs]
  (apply sorted-set (keys langs)))

(deftest lang-select
  (testing "languages constains expected keys"
    (is (every?  (set-applier service/languages) #{:es :pt :jp :en :kr :kz})))
  (testing "empty or incorrect language returns default value hello"
    (is (= (service/lang-select nil) "Hello"))
    (is (= (service/lang-select "Japanes") "Hello")))
  (testing "returns correct greeting for multiple languages"
    (is (= (service/lang-select "pt") "Olá"))
    (is (= (service/lang-select "es") "Hola"))
    (is (= (service/lang-select "kz") "сәлем"))))

(deftest greeting
  (testing "for name = nil and languagem = nil"
    (is (= (service/greeting nil nil) "Hello, unknown user\n")))
  (testing "response for name = github and languagem = nil"
    (is (= (service/greeting "github" nil) "Hello, github\n")))
  (testing "response for name = github and languagem = kr"
    (is (= (service/greeting "github" "kr") "안녕, github\n"))))
