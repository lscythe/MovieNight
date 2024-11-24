package dev.rendrap.app.movienight.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import dev.rendrap.app.movienight.core.designsystem.utils.PreviewWrapper
import dev.rendrap.app.movienight.core.designsystem.utils.ThemePreviews

@Composable
fun MVDisplayLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.displayLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.displayLarge
    )
}

@Composable
fun MVDisplayLarge(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.displayLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.displayLarge
    )
}

@Composable
fun MVDisplayMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.displayMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.displayMedium
    )
}

@Composable
fun MVDisplayMedium(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.displayMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.displayMedium
    )
}

@Composable
fun MVDisplaySmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.displaySmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
fun MVDisplaySmall(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.displaySmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
fun MVHeadlineLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.headlineLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.headlineLarge
    )
}

@Composable
fun MVHeadlineLarge(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.headlineLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.headlineLarge
    )
}

@Composable
fun MVHeadlineMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.headlineMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun MVHeadlineMedium(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.headlineMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun MVHeadlineSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.headlineSmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
fun MVHeadlineSmall(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.headlineSmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
fun MVTitleLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun MVTitleLarge(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun MVTitleMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun MVTitleMedium(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun MVTitleSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.titleSmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.titleSmall
    )
}

@Composable
fun MVTitleSmall(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.titleSmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.titleSmall
    )
}

@Composable
fun MVBodyLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun MVBodyLarge(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun MVBodyMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun MVBodyMedium(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun MVBodySmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.bodySmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
fun MVBodySmall(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.bodySmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
fun MVLabelLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.labelLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.labelLarge
    )
}

@Composable
fun MVLabelLarge(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.labelLarge.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.labelLarge
    )
}

@Composable
fun MVLabelMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.labelMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.labelMedium
    )
}

@Composable
fun MVLabelMedium(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.labelMedium.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.labelMedium
    )
}

@Composable
fun MVLabelSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.labelSmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.labelSmall
    )
}

@Composable
fun MVLabelSmall(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.labelSmall.fontSize,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = MaterialTheme.typography.labelSmall
    )
}

@ThemePreviews
@Composable
private fun MVDisplayPreview() {
    PreviewWrapper {
        Column {
            MVDisplayLarge("Display Large")
            MVDisplayMedium("Display Medium")
            MVDisplaySmall("Display Small")
        }
    }
}

@ThemePreviews
@Composable
private fun MVHeadlinePreview() {
    PreviewWrapper {
        Column {
            MVHeadlineLarge("Headline Large")
            MVHeadlineMedium("Headline Medium")
            MVHeadlineSmall("Headline Small")
        }
    }
}

@ThemePreviews
@Composable
private fun MVTitlePreview() {
    PreviewWrapper {
        Column {
            MVTitleLarge("Title Large")
            MVTitleMedium("Title Medium")
            MVTitleSmall("Title Small")
        }
    }
}

@ThemePreviews
@Composable
private fun MVBodyPreview() {
    PreviewWrapper {
        Column {
            MVBodyLarge("Body Large")
            MVBodyMedium("Body Medium")
            MVTitleSmall("Body Small")
        }
    }
}

@ThemePreviews
@Composable
private fun MVLabelPreview() {
    PreviewWrapper {
        Column {
            MVLabelLarge("Label Large")
            MVLabelMedium("Label Medium")
            MVLabelSmall("Label Small")
        }
    }
}