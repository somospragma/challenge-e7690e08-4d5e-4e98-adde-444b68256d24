Feature: Recuperación Automática de Pagos

  Scenario: Pago no procesado debido a caída del consumidor downstream
    Given el sistema está recibiendo pagos de los canales web, móvil y API externa
    And el consumidor downstream ha caído
    When un pago es intentado y falla
    Then el sistema debe encolar el pago para reintento automático
    And el pago no debe ser reprocesado si ya ha sido emitido

  Scenario: Pago procesado exitosamente después de reintento
    Given el sistema ha encolado un pago para reintento automático
    And el consumidor downstream ha sido restaurado
    When el sistema reintenta el pago
    Then el pago debe ser procesado exitosamente
    And un evento de pago exitoso debe ser emitido al sistema de auditoría

  Scenario: Pago no procesado después de múltiples reintentos
    Given el sistema ha encolado un pago para reintento automático
    And el consumidor downstream sigue caído
    When el sistema ha intentado el pago múltiples veces
    Then el pago no debe ser procesado
    And el sistema debe notificar al usuario sobre el fallo