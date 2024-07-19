export const getHTMLTemplate = (
  name,
  process_name,
  start_date,
  start_time,
  end_date,
  end_time,
  dni,
  password
) => {
  return `
    <!DOCTYPE html>
        <html lang="es">
        <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Entrega de Credenciales</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    background-color: #2c3e50;
                    color: #34495e;
                    margin: 0;
                    padding: 0;
                }
                .container {
                    background-color: #ffffff;
                    width: 80%;
                    max-width: 600px;
                    margin: 50px auto;
                    padding: 20px;
                    border-radius: 10px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                }
                .header {
                    background-color: #2980b9;
                    color: white;
                    padding: 20px;
                    text-align: center;
                    border-top-left-radius: 10px;
                    border-top-right-radius: 10px;
                }
                .header img {
                    width: 50px;
                    height: auto;
                    display: block;
                    margin: 0 auto 10px auto;
                }
                .header h1 {
                    margin: 0;
                    font-size: 24px;
                }
                .content {
                    margin: 20px 0;
                }
                .content p {
                    line-height: 1.6;
                }
                .password {
                    display: block;
                    width: 18rem;
                    margin: 10px auto;
                    padding: 10px;
                    background-color: #2c3e50;
                    color: white;
                    border-radius: 5px;
                    font-weight: bold;
                    text-align: center;
                }
                .footer {
                    text-align: center;
                    margin-top: 20px;
                    color: #34495e;
                }
                </style>
            </head>
            <body>
                <div class="container">
                <div class="header">
                    <img
                    src="https://raw.githubusercontent.com/Gabicho258/votify-frontend/master/src/assets/logo_clean_zoom.png"
                    alt="Logo"
                    />
                    <h1>Entrega de Credenciales</h1>
                </div>
                <div class="content">
                    <p>¡Hola ${name}!.</p>
                    <p>
                    Haz sido invitado al proceso electoral
                    <strong>${process_name}</strong>
                    </p>
                    <p>
                    Para poder participar del este proceso electoral deberás hacer ingreso
                    de las siguientes credenciales:
                    </p>
                    <p>Información adicional:</p>
                    <p>
                        <ul>
                            <li>El proceso electoral tendrá inicio el <strong>${start_date}</strong> a las <strong>${start_time}</strong> hora peruana.</li>
                            <li>El proceso electoral tendrá fin el <strong>${end_date}</strong> a las <strong>${end_time}</strong> hora peruana.</li>
                            <li>Una vez empieze el proceso de votación, tendrá 10 minutos para completar sus votos</li>
                        </ul>
                    </p>

                    <span class="password">DNI: ${dni}</span>
                    <span class="password">Contraseña: ${password}</span>
                    </div>
                    <div class="footer">
                        <p>¡Gracias por confiar en votify!.</p>
                    </div>
                </div>
            </body>
        </html>

    `;
};
