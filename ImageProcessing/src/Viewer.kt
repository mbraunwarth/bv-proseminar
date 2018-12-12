import java.awt.Dimension
import java.awt.image.BufferedImage
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

fun showImage(img: BufferedImage) {
    val jFrame = JFrame()
    val label = JLabel(ImageIcon(img))
    jFrame.minimumSize = Dimension(img.width, img.height)
    jFrame.contentPane.add(label)
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    jFrame.pack()
    jFrame.isVisible = true
}

fun convertToGrayscale(img: BufferedImage) {
    for (i in 1 until img.width) {
        for (j in 1 until img.height) {
            var p: Int = img.getRGB(i, j)
            val a = p shr 24 and 0xff
            val r = p shr 16 and 0xff
            val g = p shr 8 and 0xff
            val b = p and 0xff
            val avg = (r+g+b)/3
            p = (a shl 24) or (avg shl 16) or (avg shl 8) or avg
            img.setRGB(i, j, p)
        }
    }
}