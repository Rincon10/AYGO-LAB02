export const handler = async (inputData) => {
    try {
        console.log(inputData);
    
        validateInput(inputData);

        const { distance, duration, baseRate,surgeMultiplier } = inputData;

        const estimatedFare = calculateFare(
            distance,
            duration,
            baseRate,
            surgeMultiplier
        );

        return createSuccessResponse(estimatedFare);
    } catch (error) {
        console.error("Error al calcular la tarifa:", error);
        return createErrorResponse(error);
    }
};


const validateInput = (inputData) => {
    const { distance, duration, baseRate } = inputData;
    if (distance === undefined || duration === undefined || baseRate === undefined) {
        throw new Error("Distance, duration, and baseRate are required.");
    }
}


const calculateFare = (distance, duration, baseRate, surgeMultiplier = 1.0) => {
    const costPerKm = 0.05;  // Costo fijo por kilómetro
    const costPerMinute = 0.05;  // Costo fijo por minuto

    let estimatedFare = baseRate + (distance * costPerKm) + (duration * costPerMinute);

    const exchangeCopRate = 3500;

    // Aplicar el multiplicador de demanda
    estimatedFare *= surgeMultiplier;
    estimatedFare *= exchangeCopRate;

    

    // Redondear a dos decimales
    return parseFloat(estimatedFare.toFixed(2));
}


const createSuccessResponse = (estimatedFare) => {
    return {
        statusCode: 200,
        body: { estimatedFare: estimatedFare }
    };
}

// Función para crear una respuesta de error
const createErrorResponse = (error) => {
    let statusCode = 500;
    let message = "Error al calcular la tarifa.";

    // Si es un error conocido (e.g., por validación), podría ser un 400
    if (error.message.includes("required")) {
        statusCode = 400;
        message = error.message;
    }

    return {
        statusCode: statusCode,
        body: { error: message }
    };
}
