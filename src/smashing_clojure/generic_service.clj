(ns smashing-clojure.generic-service)

(def languages {:es "Hola"
                :pt "Olá"
                :jp "こんにちは"
                :en "Hello"
                :kr "안녕"
                :kz "сәлем"})

(defn lang-select [lang]
  (let [l (keyword lang)]
    (if (contains? languages l)
      (l languages)
      "Hello")))

(defn greeting [name lang]
  (if (empty? name)
    "Hello, unknown user\n"
    (str (lang-select lang) ", " name "\n")))
