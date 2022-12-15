#! /bin/bash
code=$(curl -k -o /dev/null -s -w "%{http_code}\n" https://${VAULT_AUTOUNSEAL_SERVICE_HOST}:${VAULT_AUTOUNSEAL_SERVICE_PORT}/v1/sys/health)
echo "response code is ${code}"
if [ $code -eq 503 ]; then
  echo "start unseal ..."
  curl -k --request POST https://${VAULT_AUTOUNSEAL_SERVICE_HOST}:${VAULT_AUTOUNSEAL_SERVICE_PORT}/v1/sys/unseal --data "{\"key\":\"${UNSEALKEY_1}\"}"
  curl -k --request POST https://${VAULT_AUTOUNSEAL_SERVICE_HOST}:${VAULT_AUTOUNSEAL_SERVICE_PORT}/v1/sys/unseal --data "{\"key\":\"${UNSEALKEY_2}\"}"
  curl -k --request POST https://${VAULT_AUTOUNSEAL_SERVICE_HOST}:${VAULT_AUTOUNSEAL_SERVICE_PORT}/v1/sys/unseal --data "{\"key\":\"${UNSEALKEY_3}\"}"
  curl -k --request POST https://${VAULT_AUTOUNSEAL_SERVICE_HOST}:${VAULT_AUTOUNSEAL_SERVICE_PORT}/v1/sys/unseal --data "{\"key\":\"${UNSEALKEY_4}\"}"
  curl -k --request POST https://${VAULT_AUTOUNSEAL_SERVICE_HOST}:${VAULT_AUTOUNSEAL_SERVICE_PORT}/v1/sys/unseal --data "{\"key\":\"${UNSEALKEY_5}\"}"
fi
code=$(curl -k -o /dev/null -s -w "%{http_code}\n" https://${VAULT_AUTOUNSEAL_SERVICE_HOST}:${VAULT_AUTOUNSEAL_SERVICE_PORT}/v1/sys/health)
echo "response code is ${code}"
if [ $code -eq 200 ]; then
  echo "auto unseal success"
else
  curl -k https://${VAULT_AUTOUNSEAL_SERVICE_HOST}:${VAULT_AUTOUNSEAL_SERVICE_PORT}/v1/sys/health
  exit -1
fi
