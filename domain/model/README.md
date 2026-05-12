# Armas

Cinco tipos de armas:

    - RifleAsalto
    - Francotirador
    - Escopeta
    - Pistola
    - Ametralladora Ligera

Basadas de algunas de Fallout 2

## Lista de armas

### Unordered

1. `RifleAsalto`: 
    * `FN FAL`
        + Variants
            - Default
            - Nightsight
            - HPFA (High Power Full Automatic)
        + Municion
            - 7.62mm
    * `AK-112`
        + Variantes
            - Default
            - Expanded Magazine
        + Municion utilizable
            - 5mm AP (Armor Piercing)
            - 5mm JHP (Jacketed Hollow Point)
1. `Francotirador`:
    * `M72 Gauss Rifle`
        + Municion
            - 2mm EC (Electromagnetic Cartdrige)
    * `Wattz 2000 Laser Rifle`
        + Variantes
            - Default
            - Extended Capacity
        + Municion
            - Microfusion Cell
2. `Escopeta`: 
    + `H&K CAWS`
        + Municion
            - 12 Gauge
    * `Pancor Jackhammer`
        + Municion
            - 12 Gauge
3. `Pistola`: 
    * `Desert Eagle .44`
        + Variantes
            - Default
            - Expanded Magazine
        + Municion utilizable
            - .44 Magnum FMJ (Full Metal Jacket)
            - .44 Magnum JHP (Jacketed Hollow Point)
    * `PPK12 Gauss Pistol`
        + Municion
            - 2mm EC (Electromagnetic Cartdrige)
    * `9mm Mauser`
        + Variantes
            - Default
            - Broomhandle
        + Municion utilizable
            - 9mm
            - 9mm ball
4. `AmetralladoraLigera`: 
    * `Avenger Minigun`
        + Municion utilizable
            - 5mm AP (Armor Piercing)
            - 5mm JHP (Jacketed Hollow Point)
    * `Light Support Weapon`
        + Municion
            - .223 FMJ (Full Metal Jacket)

### Herencia

__Armas --> RifleAsalto --> FN FAL__

La **recarga** se define en _`Armas`_. El **disparo** y **el cambio del modo de disparo** se define en _`RifleAsalto`_ Las **dimensiones del cargador**, **variantes de arma**, y **variantes de munición** se definen en _`FN FAL`_.

### Variantes

| Arma  | Tipo | Variantes de arma / Mods | Variantes de municion |
| - |:-: |:-:|:-:|
| FN FAL      | Rifle de Asalto | ✅     |❌ |
| AK-112      | Rifle de Asalto | ✅     |✅ |
| M72 Gauss Rifle      | Francotirador | ❌     | ❌|
| Wattz 2000 Laser Rifle      | Francotirador | ✅     | ❌|
| H&K CAWS      | Escopeta | ❌     | ❌|
| Pancor Jackhammer      | Escopeta | ❌     | ❌|
| Desert Eagle .44      | Pistola | ✅     |✅ |
| PPK12 Gauss Pistol      | Pistola | ❌     |❌ |
| 9mm Mauser      | Pistola | ✅   |✅ |
| Avenger Minigun      | Ametralladora Ligera| ❌     | ✅|
| Light Support Weapon      | Ametralladora Ligera| ❌     | ❌|

### Modos de disparo

Todos los tipos de armas que tengan ***más de un método de disparo, independientemente de si tengan un modo automáitco o no***, pueden cambiar su modo de disparo con el método (TODO): `alternarModoDisparo()`. Los modos se encuentran en el _Enum_ _`domain/enums/Disparo`_; (**solo, apuntado...**), y la cantidad de modos utilizables para cada arma puede ser cualquiera.

```java
public enum Disparo{
    SOLO,
    APUNTADO,
    AUTOMATICO
    }

    // El enum tiene 3 elementos, pero la clase Pistola puede usar unicamente SOLO y APUNTADO
 ```

Pero aquellas que implementen la _Interface_ _`util/interfaces/ModoAutomatico`_ sobrescribirán el método `cambiarModoDisparo()` para hacer esto, pues en este se diferencía si el arma hace **disparos únicos** o **ráfagas**.

Los modos de disparo del Enum `Disparo` tienen su equivalente para la Interface `ModoAutomatico`, pues las armas que implementen esta Interface, seguirán empleando los elementos del Enum.

1. Modos de disparo de `RifleAsalto`:

| Enum `Disparo` | Interface `ModoAutomatico`|
|:-:|:-:|
|SOLO|Único|
|APUNTADO|Único|
|AUTOMATICO*|Ráfaga|

###### * Un arma que tenga disponible el enum `AUTOMATICO` evidentemente siempre implementará el Interface `ModoAutomatico`

2. Modos de disparo de `AmetralladoraLigera`:

| Enum `Disparo` | Interface `ModoAutomatico`|
|:-:|:-:|
|AUTOMATICO|Ráfaga|

`AmetralladoraLigera` tiene los métodos `alternarModoDisparo()` y `alternarARafaga()` aún teniendo disponible solo un modo de disparo (_AUTOMATICO_). Esto para la implementación de la Interface `cambiarModoDisparo()`. Se verifica si el modo de disparo actual es diferente a _`AUTOMATICO`_ y lo reajusta a dicho modo.

3. Modos de disparo de `Escopeta`:

| Enum `Disparo` | Interface `ModoAutomatico`|
|:-:|:-:|
|SOLO|Único|
|AUTOMATICO|Ráfaga|

Un arma que pueda hacer disparos en ráfaga mediante la interface `ModoAutomatico` empleará por consiguiente `Disparo.AUTOMATICO`.

4. Modos de disparo de `Pistola` y `Francotirador`:

| Enum `Disparo` | Interface `ModoAutomatico`|
|:-:|:-:|
|SOLO|Único|
|APUNTADO|Único|