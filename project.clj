(defproject sample "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [hiccup "1.0.5"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [lib-noir "0.7.6"]
                 [clj-time "0.10.0"]
                 [migratus "0.8.0"]
                 [prone "1.1.4"]
                 [ring/ring-defaults "0.3.1"]]
  :plugins [[lein-ring "0.9.2"]
            [lein-ancient "0.6.10"]
            [migratus-lein "0.5.0"]]
  :migratus {:store :database
             :migration-dir "migrations"
             :db (or (System/getenv "DATABASE_URL") "postgresql://localhost:5432/sample")}
  :ring {:handler sample.handler/app
         :init sample.handler/init}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [kerodon "0.8.0"]
                        [ring/ring-mock "0.3.1"]]
         :ring {:stacktrace-middleware prone.middleware/wrap-exceptions}}})
