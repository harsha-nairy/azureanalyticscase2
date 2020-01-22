// Databricks notebook source
val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "594d5947-1852-437d-ae44-99620e2fce7e",
  "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope = "training-scope", key = "dlstoken"),
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/52ff2d36-ec5c-4571-98eb-b0928047e318/oauth2/token")

dbutils.fs.mount(
  source = "abfss://data@dlsgen2case2.dfs.core.windows.net/",
  mountPoint = "/mnt/data",
  extraConfigs = configs)