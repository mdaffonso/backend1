cd backend
start /b java -jar target/consultacep-0.0.1-SNAPSHOT.jar com.dh.consultacep.ConsultacepApplication &
cd ..
cd frontend
start /b npm start
echo "Servidor rodando..."