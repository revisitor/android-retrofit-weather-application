package ru.mtrefelov.forecaster.app.model.core

import android.os.*
import java.time.*

data class Forecast(val temperature: Double, val timestamp: LocalDateTime) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        LocalDateTime.ofInstant(Instant.ofEpochSecond(parcel.readLong()), ZoneId.systemDefault())
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeDouble(temperature)
        dest.writeLong(timestamp.toInstant(ZoneOffset.UTC).epochSecond)
    }

    companion object CREATOR : Parcelable.Creator<Forecast> {
        override fun createFromParcel(parcel: Parcel): Forecast {
            return Forecast(parcel)
        }

        override fun newArray(size: Int): Array<Forecast?> {
            return arrayOfNulls(size)
        }
    }
}